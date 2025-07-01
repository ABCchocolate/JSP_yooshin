package com.sinse.web0618.exception;

public class MemberException extends RuntimeException{
	public MemberException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	public MemberException(String msg, Throwable e) {
		// TODO Auto-generated constructor stub
		super(msg,e);
	}
	public MemberException(Throwable e) {
		// TODO Auto-generated constructor stub
		super(e);
	}
	
}
