package com.sinse.mvcapp.exception;

public class CommentException extends RuntimeException{
	public CommentException(String msg) {
		super(msg); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
	public CommentException(String msg,Throwable e) {
		super(msg,e); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
	public CommentException(Throwable e) {
		super(e); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
}
