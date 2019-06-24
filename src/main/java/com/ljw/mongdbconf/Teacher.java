package com.ljw.mongdbconf;

public class Teacher {
	private String tno;
	private String tname;
	private String type;
	private String tpassword;
	
	public Teacher(String tno, String tname, String type, String tpassword) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.type = type;
		this.tpassword = tpassword;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", type=" + type + ", tpassword=" + tpassword + "]";
	}
	
	
	
	

}
