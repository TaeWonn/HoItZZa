package user.model.vo;

import java.sql.Date;

public class User {
	
	private String userId;
	private String name;
	private String gender;
	private int point;
	private String ssn;
	private String password;
	private String email;
	private String phone;
	private String interest;
	private Date join_date;
	
	public User() {}
	
	public User(String userId, String name, String gender, int point, String ssn, String password, String email,
			String phone, String interest, Date join_date) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.point = point;
		this.ssn = ssn;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.interest = interest;
		this.join_date = join_date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", gender=" + gender + ", point=" + point + ", ssn=" + ssn
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + ", interest=" + interest
				+ ", join_date=" + join_date + "]";
	}
	
	
	
}