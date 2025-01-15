package 회원관리;

import java.awt.List;
import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<Member> memberList;
	private Utils utils;

	public MemberDAO() {
		memberList = new ArrayList();
		utils = Utils.getInstance();
		//addDummyMembers();
	}
	
	private boolean exsitData() {
		if(memberList.size() == 0) {
			System.out.println("[ 회원 목록이 존재하지 않습니다]");
			return false;
		}
		return true;
	}
	public void join() {
		// 회원가입 로직 
		String id = utils.getStringValue("[추가] 아이디 입력 >>");
		if(isValidMemberId(id)) {
			System.out.println("[ 이미 존재하는 아이디입니다]");
			System.out.println("[ 추가 실패 ]");
			return;
			
		}
		
		String pw = utils.getStringValue("[추가] 비밀번호 입력 >> ");
		String name = utils.getStringValue("[추가] 이름 입력 >> ");
		
		insertMember(new Member(id, pw, name));
		System.out.println("[ 회원 가입 성공 ]");
		
		
	}
	public void insertMember(Member member) {
		memberList.add(member);
	}
	
	private boolean isValidMemberId(String id) {
		for(Member m : memberList) {
			if(m == null) return false;
			if(m.getId().equals(id)) return true;
		}
		return false;
		
	}
	public void printAll() {
		if(!exsitData()) return;
		System.out.println("[ 회원 목록]");
		for(Member m : memberList) {
			System.out.println(m);
		}
		
	}

	public void delete() {
		if(!exsitData()) return;
		String id = utils.getStringValue("[삭제] 아이디입력 : ");
		if(!isValidMemberId(id)) {
			System.out.println("[존재하지 않는 id 입니다]");
			return;
		}
//		int idx = getMemberIdx(id);
//		removeMember(idx);
		removeMember(getMemberIdx(id));
		System.out.println("[ 삭제 성공 ]");
		
	}
	
	private void addDummyMembers() {
		for(int i =1; i <= 10; i +=1) {
			Member m = new Member("test"+i , "test"+i, "테스트"+i );
			insertMember(m);
		}
		System.out.println("[ 더미 유저 10명 생성 성공 ]");
	}
	
	private void removeMember(int idx) {
		memberList.remove(idx);
	}
	
	private int getMemberIdx(String id ) {
		int idx =0;
		for(Member m : memberList) {
			if(id.equals(m.getId())) {
				return idx;
			}
			idx+=1;
		}
		return -1;
	}
	private Member getAMemberById(String id) {
		return memberList.get(getMemberIdx(id));
	}

	public void update() {
		if(!exsitData()) return;
		String id = utils.getStringValue("[수정] 아이디 입력 >> ");
		if(!isValidMemberId(id)) {
			System.out.println("[ 존재하지 않는 아이디 입니다 ]");
			return;
		}
		
		String pw = utils.getStringValue("[수정] 비밀번호 입력 >> ");
		Member member =  getAMemberById(id);
		if(member.getPw().equals(pw)) {
			System.out.println("[ 현재와 다른 비밀번호를 입력하세요 ]");
			return;
		}
		member.setPw(pw);
		System.out.println(" [ 비밀번호 수정 완료 ] ");
		
	}

	public String getMemberList() {
		if(!exsitData()) return null;
		String data = "";
		for(Member m : memberList) {
			data += m.saveToData();
		}
		
		return data;
	}

	public void addLoadedMemberData(String data) {
		if(data.isBlank()) return;
		String[] temp = data.split("\n");
		memberList = new ArrayList();
		for(int i =0; i < temp.length; i+=1) {
			String[] info = temp[i].split("/");
			insertMember( new Member(info[0], info[1] , info[2]));
		}
		System.out.println(" [ 회원 목록 불러오기 성공 ] ");
		
	}
	
}
