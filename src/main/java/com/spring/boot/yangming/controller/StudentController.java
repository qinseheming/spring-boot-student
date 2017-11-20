package com.spring.boot.yangming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.yangming.model.Student;
import com.spring.boot.yangming.param.StudentFilter;
import com.spring.boot.yangming.service.StudentService;

import cn.lz.cloud.common.service.ClazzNote;
import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.service.ResObject;
import cn.lz.cloud.common.service.ServiceNote;
/**
 * 4.根据专业（major）查询学生信息,返回list结果，实现分页功能
 * @author YangMing
 * @date 2017年11月16日
 */
@RestController
@RequestMapping("/student")
@ClazzNote(desc = "学生Controller类")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	//添加
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ServiceNote(desc = "添加学生")
	public ResObject<Student> save(@RequestBody ReqObject<Student> reqObject) {
		try {
			Student student = studentService.save(reqObject);
			return new ResObject<Student>(reqObject, student);
		} catch (Exception e) {
			return new ResObject<Student>(reqObject, e);
		}
	}
	
	//修改
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ServiceNote(desc = "修改学生信息")
	public ResObject<Student> update(@RequestBody ReqObject<Student> reqObject) {
		try {
			Student student = studentService.update(reqObject);
			return new ResObject<Student>(reqObject, student);
		} catch (Exception e) {
			return new ResObject<Student>(reqObject, e);
		}
	}
	@RequestMapping(value = "/delete")
	@ServiceNote(desc = "批量删除学生信息")
	public ResObject<Integer> detele(@RequestBody ReqObject<List<String>> reqObject) {
		try {
			Integer row = studentService.bathDelete(reqObject);
			return new ResObject<Integer>(reqObject, row);
		} catch (Exception e) {
			return new ResObject<Integer>(reqObject, e);
		}
	}
	//根据uuid查询
	@RequestMapping(value = "/selectone")
	public ResObject<Student> selectOne(@RequestBody ReqObject<Student> reqObject) {
		try {
			Student student = studentService.selectByUuid(reqObject);
			return new ResObject<Student>(reqObject, student);
		} catch (Exception e) {
			return new ResObject<Student>(reqObject, e);
		}
	}
	//根据major查询
	@RequestMapping(value = "/selectByMajor")
	public ResObject<ResList<Student>> selectByMajor(@RequestBody ReqObject<ReqQuery<StudentFilter>> filter) {
		try {
			ResList<Student> list = studentService.selectByMajor(filter);
			return new ResObject<ResList<Student>>(filter, list);
		} catch (Exception e) {
			return new ResObject<>(filter, e);
		}
	}
}
