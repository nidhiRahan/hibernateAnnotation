package com.Anno.MTO;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Cust{

	@Id
	@Column(name = "custid")
	private int customerId;

	@Column(name = "custName", length=10)
	private String customerName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="venid",referencedColumnName="vid")
	private Ven parent;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Ven getParent() {
		return parent;
	}

	public void setParent(Ven parent) {
		this.parent = parent;
	}

}