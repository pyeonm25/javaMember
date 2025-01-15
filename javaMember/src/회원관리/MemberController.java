package 회원관리;

public class MemberController {

	private MemberDAO memberDAO;

	public MemberController() {
		memberDAO = new MemberDAO();
	}
	void run() {
		while(true) {
			System.out.println("[1]추가 [2]삭제(id->삭제) [3]수정(id->비번수정) [4]출력 [5]파일저장 [6]불러오기 [0]종료");
			int sel = Utils.getInstance().getIntValue("값 입력", 0, 6);
			if(sel == 1) {
				memberDAO.join();
			}else if(sel == 2) {
				memberDAO.delete();
			}else if(sel == 3) {
				memberDAO.update();
			}else if(sel == 4) {
				memberDAO.printAll();
			}else if(sel == 5) {
				Utils.getInstance().saveDataToFile(memberDAO.getMemberList());
			}else if(sel == 6) {
				memberDAO.addLoadedMemberData(Utils.getInstance().loadDataFromFile());
			}else if(sel == 0) {
				System.out.println("[종료]");
				break;
			}
		}
	}
}
