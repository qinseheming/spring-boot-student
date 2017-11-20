package com.spring.boot.yangming.service;

import java.util.List;

import com.spring.boot.yangming.model.Student;
import com.spring.boot.yangming.param.StudentFilter;

import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
/**
 * StudentService接口，实现对学生的增删改查
 * @author YangMing
 * @date 2017年11月16日
 */
public interface StudentService {
	/**
	 * 添加学生
	 * @param reqObject 从前端接收的Student包装类
	 * @return 返回Student类
	 */
	Student save(ReqObject<Student> reqObject);
	
	/**
	 * 根据uuid更新学生信息
	 * @param reqObject 从前端接收的Student包装类
	 * @return 返回Student类
	 */
	Student update(ReqObject<Student> reqObject);
	/**
	 * 根据uuid批量删除
	 * @param reqObject 从前端接收的Student包装类
	 * @return 返回删除多少条记录
	 */
	int bathDelete(ReqObject<List<String>> reqObject);
	/**
	 * 根据uuid查询单个学生信息
	 * @param reqObject
	 * @return
	 */
	Student selectByUuid(ReqObject<Student> reqObject);
	/**
	 * 根据专业批量查询学生信息
	 * @param filter
	 * @return
	 */
	ResList<Student> selectByMajor(ReqObject<ReqQuery<StudentFilter>> filter);
}
