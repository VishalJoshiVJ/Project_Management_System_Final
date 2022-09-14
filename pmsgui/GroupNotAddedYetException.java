package pmsgui;

public class GroupNotAddedYetException extends Exception {
	String msg = new String();
	
	public GroupNotAddedYetException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
