package vo;

public class OrderVo {
	private Long no;
	private String date;
	private int price;
	private String receive;
	private Long memberNo;

	private String dateNo;
	private String nameEmail;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public String getDateNo() {
		return dateNo;
	}

	public void setDateNo(String dateNo) {
		this.dateNo = dateNo;
	}

	public String getNameEmail() {
		return nameEmail;
	}

	public void setNameEmail(String nameEmail) {
		this.nameEmail = nameEmail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[dateNo=" + dateNo + ", nameEmail=" + nameEmail + ", price=" + price + ", receive=" + receive + "]";
	}
}