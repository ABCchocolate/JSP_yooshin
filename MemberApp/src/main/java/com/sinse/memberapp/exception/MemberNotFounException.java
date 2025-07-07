package com.sinse.memberapp.exception;

public class MemberNotFounException extends RuntimeException{
	public MemberNotFounException(String msg) {
		super(msg);
	}
	public MemberNotFounException(String msg, Throwable e) {
		super(msg,e);
	}
	public MemberNotFounException(Throwable e) {
		super(e);
	}
}
