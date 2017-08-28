package orderbase;

public class ordersubdetail {
	private long orderid;
	private long prdid;
	private String prdname;
	private int prdcount;
	private double prdprice;
	private double sumprice;
	
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public long getPrdid() {
		return prdid;
	}
	public void setPrdid(long prdid) {
		this.prdid = prdid;
	}
	public String getPrdname() {
		return prdname;
	}
	public void setPrdname(String prdname) {
		this.prdname = prdname;
	}
	public int getPrdcount() {
		return prdcount;
	}
	public void setPrdcount(int prdcount) {
		this.prdcount = prdcount;
	}
	public double getPrdprice() {
		return prdprice;
	}
	public void setPrdprice(double prdprice) {
		this.prdprice = prdprice;
	}
	public double getSumprice() {
		return sumprice;
	}
	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	@Override
	public String toString() {
		return "ordersubdetail [orderid=" + orderid + ", prdid=" + prdid + ", prdname=" + prdname + ", prdcount="
				+ prdcount + ", prdprice=" + prdprice + ", sumprice=" + sumprice + "]";
	}
	
	
	
}
