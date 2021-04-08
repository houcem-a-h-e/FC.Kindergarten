package tn.esprit.spring.payment;

public class Payment {
	private String description;
	private int amount;
	private Currency currency;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Payment(String description, int amount, Currency currency) {
		super();
		this.description = description;
		this.amount = amount;
		this.currency = currency;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [description=" + description + ", amount=" + amount + ", currency=" + currency + "]";
	}
	
}
