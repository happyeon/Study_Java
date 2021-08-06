package com.kh.controller;

import java.util.List;
import java.util.Scanner;

import com.kh.biz.TestBiz;
import com.kh.dto.TestDto;

public class TestController {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		sb.append("1.전체출력\n")
		  .append("2.선택출력\n")
		  .append("3.추가\n")
		  .append("4.수정\n")
		  .append("5.삭제\n")
		  .append("6.종료\n")
		  .append("번호선택 : \n");
		System.out.println(sb);
		select = sc.nextInt();
	
		return select;
	}
	
	public static void main(String[] args) {
		int select = 0;
		TestBiz biz = new TestBiz();
		
		while (select != 6) {
			select = getMenu();
			switch(select) {
			case 1:
				List<TestDto> list = biz.selectList();
				for (TestDto dto : list) {
					System.out.println(dto);
				}
				break;
			case 2:
				System.out.println("출력할 번호 : ");
				int no = sc.nextInt();
				TestDto selectOneDto = biz.selectOne(no);
				System.out.println(selectOneDto);
				
				break;
			case 3:
				System.out.println("추가");
				System.out.println("NO : ");
				int insert_no = sc.nextInt();
				System.out.println("이름 : ");
				String insert_name = sc.next();
				System.out.println("번호 : ");
				String insert_phone = sc.next();
				System.out.println("주소 : ");
				String insert_addr = sc.next();
				
				TestDto insertDto = new TestDto(insert_no, insert_name, insert_phone, insert_addr);
				int insertRes = biz.insert(insertDto);
				if (insertRes > 0) {
					System.out.println("추가 성공!");
				} else {
					System.out.println("추가 실패!");
				}
				break;
			case 4:
				System.out.println("수정");
				System.out.println("수정할 NO : ");
				int update_no = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String update_name = sc.next();
				System.out.println("수정할 번호 : ");
				String update_phone = sc.next();
				System.out.println("수정할 주소 : ");
				String update_addr = sc.next();
				
				TestDto updateDto = new TestDto(update_no, update_name, update_phone, update_addr);
				int updateRes = biz.update(updateDto);
				if(updateRes > 0) {
					System.out.println("수정 성공!");
				} else {
					System.out.println("수정 실패!");
				}
				break;
			case 5:
				System.out.println("삭제");
				System.out.println("삭제할 번호 : ");
				int delete_no = sc.nextInt();
				
				int deleteRes = biz.delete(delete_no);
				if(deleteRes > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
