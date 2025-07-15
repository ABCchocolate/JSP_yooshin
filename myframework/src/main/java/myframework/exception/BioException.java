package myframework.exception;

public class BioException extends RuntimeException{
	public BioException(String msg,Throwable e) {
		super(msg,e);
	}
	public BioException(String msg) {
		super(msg);
	}
	public BioException(Throwable e) {
		super(e);
	}
}
