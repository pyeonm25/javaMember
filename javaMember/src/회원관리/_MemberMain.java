package 회원관리;

// DAO - data access object : 여러 Member 들을 관리하는 클래스 : CRUD 

// Member (VO ) - value object : 실제 데이터를 저장한 클래스  

// Controller - 총 메뉴 홈 => 사용자와 실체 기능구현하는 클래스를 연결하는 클래스 

// Utils  => 여러 클래스에서 공유해서 사용하는 자원 : Scanner... Random... File.... 

public class _MemberMain {
	public static void main(String[] args) {
		MemberController controller = new MemberController();
		controller.run();
	
	}
}
