package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Studentplay {
	
	public static void main(String[] args) {

		 StudentPro sp = new StudentPro();
		 Scanner sc = new Scanner(System.in);
	while(true)
	{
		System.out.println("=======학생관리 시스탬=========");
		System.out.println("| 1.학생 정보 목록                           |");
		System.out.println("| 2.학생 등록                                  |");
		System.out.println("| 3.학생삭제                                   |");
		System.out.println("| 4.학생정보 수정                            |");
		System.out.println("| 5.종료                                         |");
		System.out.println("==========================");
		System.out.print(">>>  ");
		
		
		  int num = 0;
		   try {
			   num = sc.nextInt();
			   if(!(num>0 && num<6))
			   {
				   throw new InputMismatchException();
			   }
		   }catch(InputMismatchException e){
			   System.out.println(e);
		   }
		   
		   switch(num)
		   {
		   case 1:
			   sp.ShowStudentList();
			   break;
			   
		   case 2:
			   sp.insertStudent();
			   break;
			   
		   case 3:
			   sp.DeleteStudent();
			   break;
					  
		   case 4:
			   sp.UpdateStudent();
			   break;
			   
		   case 5:
			   System.out.println("프로그램을 종료합니다");
			   System.exit(0);
		   }
	   }
	}
}
