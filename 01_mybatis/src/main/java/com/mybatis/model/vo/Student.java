package com.mybatis.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String email;
	private String addr;
	private Date reg_date;
}
