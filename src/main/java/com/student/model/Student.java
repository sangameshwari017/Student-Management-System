package com.student.model;

public class Student {
	
	private int sid;
	private String sname;
	private int age;
	private String course;
	private String city;
	private String mobile;
	private String email;
	private String gender;
	private String dob;
	private String bloodgroup;
	private String parentname;
	private String parentmobile;
	private String address;
	
	
	public Student()
	{
		
	}
	
	
	


	public Student(int sid, String sname, int age, String course, String city, String mobile, String email,
			String gender, String dob, String bloodgroup, String parentname, String parentmobile, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.course = course;
		this.city = city;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.bloodgroup = bloodgroup;
		this.parentname = parentname;
		this.parentmobile = parentmobile;
		this.address = address;
	}





	public int getSid() {
		return sid;
	}





	public void setSid(int sid) {
		this.sid = sid;
	}





	public String getSname() {
		return sname;
	}





	public void setSname(String sname) {
		this.sname = sname;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public String getCourse() {
		return course;
	}





	public void setCourse(String course) {
		this.course = course;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getMobile() {
		return mobile;
	}





	public void setMobile(String mobile) {
		this.mobile = mobile;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public String getDob() {
		return dob;
	}





	public void setDob(String dob) {
		this.dob = dob;
	}





	public String getBloodgroup() {
		return bloodgroup;
	}





	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}





	public String getParentname() {
		return parentname;
	}





	public void setParentname(String parentname) {
		this.parentname = parentname;
	}





	public String getParentmobile() {
		return parentmobile;
	}





	public void setParentmobile(String parentmobile) {
		this.parentmobile = parentmobile;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + ", course=" + course + ", city=" + city
				+ ", mobile=" + mobile + ", email=" + email + ", gender=" + gender + ", dob=" + dob + ", bloodgroup="
				+ bloodgroup + ", parentname=" + parentname + ", parentmobile=" + parentmobile + ", address=" + address
				+ "]";
	}






	
	
	

}
