package kr.or.connect.jdbcbusiness;

import java.util.Scanner;

import kr.or.connect.jdbcbusiness.dao.*;
import kr.or.connect.jdbcbusiness.dto.*;


public class BCExam1 {
	public static void main(String[] args) {
		int n=0;
		String name, pnum, company;
		Scanner s = new Scanner(System.in);
		while(n!=3) {
			System.out.println("-----------------");
			System.out.println("1. 명함 입력\n2. 명함 검색\n3. 종료");
			System.out.println("-----------------");
			System.out.print("메뉴를 입력하세요 : ");
			n = s.nextInt();
			
			if(n==3) {
				break;
			}
			else if(n==1) { //insert
				System.out.print("이름을 입력하세요 : ");
				name = s.next();
				System.out.print("전화번호를 입력하세요 : ");
				pnum = s.next();
				System.out.print("회사이름을 입력하세요 : ");
				company = s.next();
				BCard bcard = new BCard(name, pnum, company);
				
				BCardDao dao = new BCardDao();
				dao.addBCard(bcard);
			}
			else if(n==2) {
				System.out.print("검색할 이름을 입력하세요. (like검색) : ");
				name = s.next();
				BCardDao dao = new BCardDao();
				BCard bcard = dao.getBCard(name);
				System.out.println(bcard);
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		s.close();
	}
}
