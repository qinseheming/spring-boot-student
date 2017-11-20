package com.spring.boot.yangming.param;

import com.spring.boot.yangming.util.reqErrCodes;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;

/**
 * Student前端输入参数
 * @author YangMing
 * @date 2017年11月17日
 */
@PojoNote(desc = "Student输入参数", resource = "studentFilter")
public class StudentFilter {
	
	@FieldNote(desc = "专业", notNull = true)
	private String major;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	public void isValidFilter() {
		if ((major == null || major.isEmpty())) {
			throw reqErrCodes.FILTER_ERROR_CORP.exception("必须输入条件major");
		}
	}
}
