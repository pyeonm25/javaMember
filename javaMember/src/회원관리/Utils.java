package 회원관리;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	
	private Utils() {}
	private static Utils instance;

	public static Utils getInstance() {
		if(instance == null) instance = new Utils();
		return instance;
	}
	
	private Scanner sc = new Scanner(System.in);
	private  final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName()
			+ "\\";
	private  final String filePath = CUR_PATH + "member.txt";

	public  int getIntValue(String msg, int start, int end) {
		System.out.printf("[%d -%d ] %s >> ", start, end, msg);
		while (true) {
			try {
				int num = sc.nextInt();
				sc.nextLine();
				if (num < start || num > end) {
					System.out.println(" 올바른 범위내로 입력하세요");
					continue;
				}
				return num;
			} catch (InputMismatchException e) {
				System.out.println(" 숫자 값을 입력하세요 ");
				sc.nextLine();
				continue;
			}

		}
	}

	public  String getStringValue(String msg) {
		System.out.println(msg);
		while(true) {
			String value = sc.nextLine();
			if(value.isBlank()) {
				System.out.println("값을 입력하세요");
				continue;
			}
			return value;
		}
	}
	
	public  void saveDataToFile(String data) {
		if(data == null) return;
		
		try(FileWriter fw = new FileWriter(filePath)){
			fw.write(data);
			System.out.println(filePath +" 저장 성공");
		} catch (IOException e) {
			System.out.println(filePath +" 저장 실패");
		}
	}

	public  String loadDataFromFile() {
		String data = "";
		
		try(FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr);){
			
			int idx =0;
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				data  += idx ==0? line : "\n" + line;
				idx+=1;
			}
			
			System.out.println(filePath + " 파일 불러오기 성공");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
			System.out.println("파일 저장 먼저 해주세요 ");
//			File file = new File(filePath);
//			try {
//				file.createNewFile();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
		} catch (IOException e) {
			System.out.println(filePath + " 파일 불러오기 실패");
		}

		return data;
	}
}
