package model.vo;
public class User {
	private String name;
	private String phone;
	private String profile;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String phone, String profile) {
		super();
		this.name = name;
		this.phone = phone;
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return name+","+phone+","+profile;
					//,로 분류한걸 csv라고함
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

}
