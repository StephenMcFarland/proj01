package com.proj01.models;

public class Reimbursement {
	private int reimId;
    private String reimOwner;
    private String reimResolver;
    private double reimAmount;
    private String reimStatus;
    //private enum reimStatus{approved,denied,pending,resolved};


    public Reimbursement(int reimId, String reimOwner, String reimResolver, double reimAmount,String reimStatus) {
        this.reimId = reimId;
        this.reimOwner = reimOwner;
        this.reimResolver = reimResolver;
        this.reimAmount = reimAmount;
        this.reimStatus = reimStatus;
    }


	public int getReimId() {
		return reimId;
	}


	public void setReimId(int reimId) {
		this.reimId = reimId;
	}


	public String getReimOwner() {
		return reimOwner;
	}


	public void setReimOwner(String reimOwner) {
		this.reimOwner = reimOwner;
	}


	public String getReimResolver() {
		return reimResolver;
	}


	public void setReimResolver(String reimResolver) {
		this.reimResolver = reimResolver;
	}


	public double getReimAmount() {
		return reimAmount;
	}


	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}


	public String getReimStatus() {
		return reimStatus;
	}


	public void setReimStatus(String reimStatus) {
		this.reimStatus = reimStatus;
	}


	@Override
	public String toString() {
		return " " + reimId + ", " + reimOwner + ", " + reimResolver
				+ ", " + reimAmount + ", " + reimStatus;
	}


}
