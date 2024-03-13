package project1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.xml.soap.Name;

public class StudentPro {
	Scanner sc = new Scanner(System.in);
	StudentDAO dao;

	public StudentPro() {
		dao = new StudentDAO();
	}

	// 학생 등록 정보 처리

	public void insertStudent() {
		System.out.println("===========================");
		System.out.println("학생 정보를 입력하세요");
		System.out.print(">>>학번: ");
		String code = sc.nextLine();
		System.out.print(">>>이름: ");
		String name = sc.nextLine();
		System.out.print(">>>학과: ");
		String depart = sc.nextLine();
		System.out.print(">>>전화번화: ");
		String num = sc.nextLine();
		System.out.print(">>>학점: ");
		String jumsu = sc.nextLine();
		System.out.println("===========================");
		
		StudentInfor infor = new StudentInfor(code, name, depart, num, jumsu);
		boolean r = dao.insertStudent(infor);
		if (r) {
			System.out.println("학생정보가 정상적으로 처리되었습니다");
		} else {
			System.out.println("학생정보가 정상적으로 처리되지 않았습니다");
		}
	}

	public void ShowStudentList() {
		List<StudentInfor> list = dao.getStundetList();

		System.out.println("학생 목록 정보");
		System.out.println("");
		if (list != null & list.size() > 0) {
			System.out.println("학번\t 이름\t\t 학과\t\t\t\t 연락처\t\t 점수");
			System.out.println("");

			for (StudentInfor Infor : list) {
				System.out.println(Infor);
			}
		} else {
			System.out.println("저장된 학생 정보가 없습니다.");
		}
		System.out.println("");

	}

	// 학생정보 수정
	public void UpdateStudent() {
		System.out.println("수정할 학생의 학번을 입력하세요");
		System.out.print(">>>");
		String code = sc.nextLine();
		StudentInfor Infor = dao.getStudent(code);
		if (Infor != null) {
			System.out.println(Infor.getInfo());

				System.out.print(">>>수정할 이름: ");
				String name = sc.nextLine();

				if (name.trim().equals("")) {
					name = Infor.getName();
				}
				System.out.print(">>>수정할 학과: ");
				String depart = sc.nextLine();
				if (depart.trim().equals("")) {
					depart = Infor.getDepart();
				}
				System.out.print(">>>수정할 전화번호: ");
				String num = sc.nextLine();
				if (num.trim().equals("")) {
					num = Infor.getNum();
				}
				System.out.print(">>>수정할 학점: ");
				String jumsu = sc.nextLine();
				if (jumsu.trim().equals("")) {
					jumsu = Infor.getJumsu();
				}
				
				Infor = new StudentInfor(code, name , depart, num, jumsu);
				
				boolean r = dao.updateStudent(Infor);
				
				if(r)
				{
					System.out.println("학생의 정보를 수정했습니다.");
					System.out.print(Infor.getInfo());
					
				}
				else {
					System.out.println("학생의 정보가 수정 되지 않았습니다");
				
				}
		}
	}
		
	//학생 정보 삭제 
	
	public void DeleteStudent() {
		 
		System.out.println("삭제할 학생의 학번을 입력해주세요");
		String code = sc.nextLine();
		StudentInfor infor = dao.getStudent(code);
		if(infor != null)
		{
			System.out.println(infor.getInfo());
		

				boolean r =dao.deleteStudent(code);
				
				if(r) 
				{
					System.out.println("학생의 정보가 삭제 되었습니다");
				}
				else {
					System.out.println("학생의 정보가 삭제 되지 않았습니다");
				}
			}
		
		}	

}
