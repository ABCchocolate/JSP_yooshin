package com.sinse.mvcapp.exception;

public class NoticeException extends RuntimeException{
	public NoticeException(String msg) {
		super(msg); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
	public NoticeException(String msg,Throwable e) {
		super(msg,e); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
	public NoticeException(Throwable e) {
		super(e); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
}
