package com.spring.boot.yangming.util;

import cn.lz.cloud.common.exception.code.ErrorCode0;
import cn.lz.cloud.common.exception.code.ErrorCode1;

public class reqErrCodes {
	public static final ErrorCode1 FILTER_ERROR_CORP = new ErrorCode1("REQ001", "请输入查询条件[{0}]");
	public static final ErrorCode0 NO_MESSAGE_DELETED = new ErrorCode0("REQ002", "删除信息为空，请选择删信息");
}
