package com.sinse.memberapp.model;

import java.util.List;

import lombok.Data;

@Data
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	//하나의 부서는 여러명의 사원을 포함 시킬 수 있다.
	private List<Emp> emplist;
	
}
