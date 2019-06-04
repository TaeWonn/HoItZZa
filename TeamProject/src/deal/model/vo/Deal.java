package deal.model.vo;

import java.sql.Date;

public class Deal {
	// field
	private int hisNo;
	private String hisSeller;
	private String hisBuyer;
	private String hisSubject;
	private int hisPrice;
	private String sellerOk;
	private String buyerOk;
	private String deliveryOk;
	private String deliveryInfo;
	private Date hisDate;
	
	// constructor
	public Deal() {}

	public Deal(int hisNo, String hisSeller, String hisBuyer, String hisSubject, int hisPrice, String sellerOk,
			String buyerOk, String deliveryOk, String deliveryInfo, Date hisDate) {
		this.hisNo = hisNo;
		this.hisSeller = hisSeller;
		this.hisBuyer = hisBuyer;
		this.hisSubject = hisSubject;
		this.hisPrice = hisPrice;
		this.sellerOk = sellerOk;
		this.buyerOk = buyerOk;
		this.deliveryOk = deliveryOk;
		this.deliveryInfo = deliveryInfo;
		this.hisDate = hisDate;
	}

	// getter/setter
	public int getHisNo() {
		return hisNo;
	}

	public void setHisNo(int hisNo) {
		this.hisNo = hisNo;
	}

	public String getHisSeller() {
		return hisSeller;
	}

	public void setHisSeller(String hisSeller) {
		this.hisSeller = hisSeller;
	}

	public String getHisBuyer() {
		return hisBuyer;
	}

	public void setHisBuyer(String hisBuyer) {
		this.hisBuyer = hisBuyer;
	}

	public String getHisSubject() {
		return hisSubject;
	}

	public void setHisSubject(String hisSubject) {
		this.hisSubject = hisSubject;
	}

	public int getHisPrice() {
		return hisPrice;
	}

	public void setHisPrice(int hisPrice) {
		this.hisPrice = hisPrice;
	}

	public String getSellerOk() {
		return sellerOk;
	}

	public void setSellerOk(String sellerOk) {
		this.sellerOk = sellerOk;
	}

	public String getBuyerOk() {
		return buyerOk;
	}

	public void setBuyerOk(String buyerOk) {
		this.buyerOk = buyerOk;
	}

	public String getDeliveryOk() {
		return deliveryOk;
	}

	public void setDeliveryOk(String deliveryOk) {
		this.deliveryOk = deliveryOk;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public Date getHisDate() {
		return hisDate;
	}

	public void setHisDate(Date hisDate) {
		this.hisDate = hisDate;
	}

	// tostring
	@Override
	public String toString() {
		return "Deal [hisNo=" + hisNo + ", hisSeller=" + hisSeller + ", hisBuyer=" + hisBuyer + ", hisSubject="
				+ hisSubject + ", hisPrice=" + hisPrice + ", sellerOk=" + sellerOk + ", buyerOk=" + buyerOk
				+ ", deliveryOk=" + deliveryOk + ", deliveryInfo=" + deliveryInfo + ", hisDate=" + hisDate + "]";
	}	
}
