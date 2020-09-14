package com.beans;

public class TaxDetails 
{
	private int customerId;
	private int incomeTaxPin;
	private int grossIncome;
	private int taxableIncome;	
	private int totalTaxPayable;
	private String financialYear;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getIncomeTaxPin() {
		return incomeTaxPin;
	}
	public void setIncomeTaxPin(int incomeTaxPin) {
		this.incomeTaxPin = incomeTaxPin;
	}
	public int getGrossIncome() {
		return grossIncome;
	}
	public void setGrossIncome(int grossIncome) {
		this.grossIncome = grossIncome;
	}
	public int getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(int taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public int getTotalTaxPayable() {
		return totalTaxPayable;
	}
	public void setTotalTaxPayable(int totalTaxPayable) {
		this.totalTaxPayable = totalTaxPayable;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public TaxDetails(int customerId, int incomeTaxPin, int grossIncome, int taxableIncome, int totalTaxPayable,
			String financialYear) {
		super();
		this.customerId = customerId;
		this.incomeTaxPin = incomeTaxPin;
		this.grossIncome = grossIncome;
		this.taxableIncome = taxableIncome;
		this.totalTaxPayable = totalTaxPayable;
		this.financialYear = financialYear;
	}
	public TaxDetails() {
		super();
	}
	@Override
	public String toString() {
		return "TaxDetails [customerId=" + customerId + ", incomeTaxPin=" + incomeTaxPin + ", grossIncome="
				+ grossIncome + ", taxableIncome=" + taxableIncome + ", totalTaxPayable=" + totalTaxPayable
				+ ", financialYear=" + financialYear + "]";
	}
	
	

}
