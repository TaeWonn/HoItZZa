package user.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class User {
	
	private String userId;
	private String password;
	private String name;
	private String gender;
	private String ssn;
	private String email;
	private String phone;
	private String addr;
	private int point;
	private String[] interest;
	private Date join_date;
	
	public User() {}

	public User(String userId, String password, String name, String gender, String ssn, String email, String phone,
			String addr, int point, String[] interest, Date join_date) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.point = point;
		this.interest = interest;
		this.join_date = join_date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr1) {
		this.addr = addr1;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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


	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
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
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", gender=" + gender + ", ssn="
				+ ssn + ", email=" + email + ", phone=" + phone + ", addr=" + addr + ", point=" + point + ", interest="
				+ Arrays.toString(interest) + ", join_date=" + join_date + "]";
	}
	
	
}

