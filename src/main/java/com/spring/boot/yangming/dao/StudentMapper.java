package com.spring.boot.yangming.dao;

import java.util.List;

import com.spring.boot.yangming.model.Student;
/**
 * Student DAO层接口
 * @author YangMing
 * @date 2017年11月16日
 */
public interface StudentMapper {
    /**
     * 添加学生
     * @param record
     * @return
     */
	int insert(Student student);
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	int update(Student record);
	/**
	 * 批量删除学生信息
	 * @param list
	 * @return
	 */
	int bathDelete(List<String> list);
	/**
	 * 根据uuid查询单个学生信息
	 * @param stuent
	 * @return
	 */
	Student selectByUuid(Student stuent);
	/**
	 * 根据专业批量查询学生信息
	 * @param major
	 * @return
	 */
	List<Student> selectByMajor(String major);
}