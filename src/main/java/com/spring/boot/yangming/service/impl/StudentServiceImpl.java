package com.spring.boot.yangming.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.boot.yangming.dao.StudentMapper;
import com.spring.boot.yangming.model.Student;
import com.spring.boot.yangming.param.StudentFilter;
import com.spring.boot.yangming.service.StudentService;
import com.spring.boot.yangming.util.reqErrCodes;

import cn.lz.cloud.common.exception.LzErrException;
import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.util.DateUtil;
import cn.lz.cloud.common.util.UUID;
/**
 * StudentService实现类
 * @author YangMing
 * @date 2017年11月16日
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	protected static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	//新增
	@Override
	@Transactional
	public Student save(ReqObject<Student> reqObject) {
		Student student = reqObject.getObject();
		student.setUuid(UUID.getUUID());
		student.setCreatetime(DateUtil.longDateTime());
		int result = studentMapper.insert(student);
		if(result >= 0) {
			logger.info("保存成功");
		} else {
			logger.debug("保存失败");
		}
		return student;
	}
	//更新
	@Override
	@Transactional
	public Student update(ReqObject<Student> reqObject) {
		Student student = reqObject.getObject();
		student.setEditetime(DateUtil.longDateTime());
		int result = studentMapper.update(student);
		if(result >= 0) {
			logger.info("修改成功");
		} else {
			logger.debug("修改失败");
		}
		return student;
	}
	//批量删除
	@Override
	@Transactional
	public int bathDelete(ReqObject<List<String>> reqObject) {
		List<String> list = reqObject.getObject();
		if (list != null && list.size() > 0) {
			return studentMapper.bathDelete(list);
		} else {
			logger.error("删除信息为空，请选择删除信息");
			throw new reqErrCodes().NO_MESSAGE_DELETED.exception();
		}
	}
	@Override
	public Student selectByUuid(ReqObject<Student> reqObject) {
		Student studentObj = reqObject.getObject();
		Student student = studentMapper.selectByUuid(studentObj);
		return student;
	}
	@Override
	public ResList<Student> selectByMajor(ReqObject<ReqQuery<StudentFilter>> filter) {
		int startPage = filter.getObject().getStartPage();
		int pageRow = filter.getObject().getPageRow();
		filter.getObject().getObject().isValidFilter();
		String major = filter.getObject().getObject().getMajor();
		
		if(startPage == 0 && pageRow == 0) {
			List<Student> list = studentMapper.selectByMajor(major);
			ResList<Student> resList = new ResList<Student>(list);
			if(list.size() > ReqQuery.totalCount) {
				throw new LzErrException("900001","数据过大，请分页");
			}
			return resList;
		}
		
		PageHelper.startPage(startPage, pageRow);
		PageInfo<Student> page = null;
		List<Student> list = studentMapper.selectByMajor(major);
		page = new PageInfo<Student>(list);
		ResList<Student> resList = new ResList<Student>(list);
		resList.setStartPage(startPage);
		resList.setPageRow(pageRow);
		resList.setTotalRow(page.getTotal());
		return resList;
	}

}
