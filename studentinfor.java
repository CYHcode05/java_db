package project1;

import java.util.Formatter;

public class StudentInfor {

	private String code;
	private String name; 
	private String depart;
	private String num;
	private String jumsu;
	

	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDepart() {
		return depart;
	}



	public void setDepart(String depart) {
		this.depart = depart;
	}



	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
	}



	public String getJumsu() {
		return jumsu;
	}



	public void setJumsu(String jumsu) {
		this.jumsu = jumsu;
	}



	public StudentInfor(String code,String name,String depart,String num,String jumsu) {
		super();
		this.code = code;
		this.name = name;
		this.depart = depart;
		this.num = num;
		this.jumsu = jumsu;
	}


	
	@Override
	public String toString() {
		Formatter fm = new Formatter();
	    String meminfo = fm.format("%7s\t %-20s\t %-40s\t %-14s\t %-7s\t", 
	    		                   code, name,depart,num,jumsu).toString();
		return meminfo; 
	}
	
	public String getInfo()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[" + code+"] 학생의 정보\n");
		sb.append("이름  : " +name +"\n");
		sb.append("학과 : " + depart+"\n");
		sb.append("전화번호 :" +num + "\n");
		sb.append("학점 :" + jumsu+ "\n");
		
		return sb.toString();
	}
}
