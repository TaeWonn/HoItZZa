package point.model.vo;

import java.sql.Date;

public class Point {	
//	--포인트 충전내역 테이블
//	create table  point_charge  (
//		 charge_no number not null,
//		 charge_writer varchar2(15) not null,
//		 charge_money number not null,
//		 charge_date date default sysdate not null,
//	     constraint pk_charge_no primary key(charge_no),
//	     constraint fk_charge_writer foreign key(charge_writer) references user_point(user_id)
//	);
	
	// field
	private int chargeNo;
	private String chargeWriter;
	private int chargeMoney;
	private Date chargeDate;
	
	
	// constructor
	public Point() {}

	public Point(int chargeNo, String chargeWriter, int chargeMoney, Date chargeDate) {
		super();
		this.chargeNo = chargeNo;
		this.chargeWriter = chargeWriter;
		this.chargeMoney = chargeMoney;
		this.chargeDate = chargeDate;
	}

	// getter/setter
	public int getChargeNo() {
		return chargeNo;
	}

	public void setChargeNo(int chargeNo) {
		this.chargeNo = chargeNo;
	}

	public String getChargeWriter() {
		return chargeWriter;
	}

	public void setChargeWriter(String chargeWriter) {
		this.chargeWriter = chargeWriter;
	}

	public int getChargeMoney() {
		return chargeMoney;
	}

	public void setChargeMoney(int chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public Date getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	// tostring
	@Override
	public String toString() {
		return "Point [chargeNo=" + chargeNo + ", chargeWriter=" + chargeWriter + ", chargeMoney=" + chargeMoney
				+ ", chargeDate=" + chargeDate + "]";
	}	
}
