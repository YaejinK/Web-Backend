package kr.or.connect.jdbcbusiness.dto;

public class BCard {
	private String name;
	private String pnum;
	private String company;
	
	public BCard() {
		
	}
	public BCard(String name, String pnum, String company) {
		super();
		this.name = name;
		this.pnum = pnum;
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "BCard [name=" + name + ", pnum=" + pnum + ", company=" + company + "]";
	}
}
