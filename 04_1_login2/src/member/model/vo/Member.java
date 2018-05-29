package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -336794342338705489L;
	
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enroll_datess;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Member(String member_id, String member_pwd, String member_name, String gender, int age, String email,
			String phone, String address, String hobby, Date enroll_datess) {
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enroll_datess = enroll_datess;
	}
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", gender=" + gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", hobby=" + hobby + ", enroll_datess=" + enroll_datess + "]";
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnroll_datess() {
		return enroll_datess;
	}
	public void setEnroll_datess(Date enroll_datess) {
		this.enroll_datess = enroll_datess;
	}

}
