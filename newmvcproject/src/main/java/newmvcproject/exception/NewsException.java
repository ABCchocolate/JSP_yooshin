package newmvcproject.exception;

public class NewsException extends RuntimeException{
	public NewsException(String msg) {
		super(msg); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
	public NewsException(String msg,Throwable e) {
		super(msg,e); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
	public NewsException(Throwable e) {
		super(e); //생성자는 물려받지 못하므로 부모의 생성자를 호출해야한다.
	}
}
