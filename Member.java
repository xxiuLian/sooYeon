package com.mvc.model.vo;

public class Member {
	
	private String memberId; //아이디
	private String memberPwd; //비번
	private String memberName; //이름
	private String citizenNo; //주민번호
	private double height; //키
	
	public Member() {
		//기본생성자
	}

	public Member(String memberId, String memberPwd, String memberName, String citizenNo, double height) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.citizenNo = citizenNo;
		this.height = height;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCitizenNo() {
		return citizenNo;
	}

	public void setCitizenNo(String citizenNo) {
		this.citizenNo = citizenNo;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public String information() {
		return "아이디=" + memberId + ", 비밀번호=" + memberPwd + ", 이름=" + memberName
				+ ", 주민번호=" + citizenNo + ", 키=" + height;
	}

}
