package vw.springbootreact.bookapp.exception;

public class BookNotFoundException extends RuntimeException{
	
	private String msg;

	public BookNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
