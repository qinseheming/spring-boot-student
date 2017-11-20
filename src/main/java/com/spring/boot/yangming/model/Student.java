package com.spring.boot.yangming.model;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;

/**
 * student实体类
 * @author YangMing
 * @date 2017年11月16日
 */
@PojoNote(desc = "student实体类", resource = "student")
public class Student {
	
	@FieldNote(desc = "uuid", length = 50, notNull = true)
    private String uuid;
	
	@FieldNote(desc = "编号", length = 50, notNull = true)
	private String code;
	
	@FieldNote(desc = "年龄", length = 3)
	private Integer age;
	
	@FieldNote(desc = "班级", length = 50)
	private String classname;
	
	@FieldNote(desc = "姓名", length = 50, notNull = true)
	private String name;
	
	@FieldNote(desc = "专业", length = 50)
	private String major;
	
	@FieldNote(desc = "创建时间", length = 50)    
    private String createtime;
	
	@FieldNote(desc = "修改时间", length = 50)
    private String editetime;
	
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getEditetime() {
        return editetime;
    }

    public void setEditetime(String editetime) {
        this.editetime = editetime == null ? null : editetime.trim();
    }
}