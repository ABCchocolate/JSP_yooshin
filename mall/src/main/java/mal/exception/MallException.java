package mal.exception;

public class MallException extends RuntimeException{
	public MallException(String msg,Throwable e) {
		super(msg,e);
	}
	public MallException(String msg) {
		super(msg);
	}
	public MallException(Throwable e) {
		super(e);
	}
}
