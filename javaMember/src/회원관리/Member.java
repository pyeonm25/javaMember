package 회원관리;

public class Member {
	private String id;
	private String pw;
	private String name;
	
	Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}

	public String saveToData() {
		return String.format("%s/%s/%s\n", id,pw,name);
	}
	
	@Override
	public String toString() {
		return String.format("%s \t %s \t %s", id, pw, name);
	}
	
	
}
