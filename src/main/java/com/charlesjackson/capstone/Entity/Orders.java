package com.charlesjackson.capstone.Entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	@ManyToOne
	@JoinColumn(name ="emailid")
	private Login login;

	private String firstname;
	private String secondname;
	private String address;
	private String phone;
	@OneToMany(cascade=CascadeType.ALL)
		private List<OrderDetails> orderDetails;
	public Orders(int orderid, Login login, String firstname, String secondname, String address, String phone) {
		super();
		this.orderid = orderid;
		this.login = login;
		this.firstname = firstname;
		this.secondname = secondname;
		this.address = address;
		this.phone = phone;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", login=" + login + ", firstname=" + firstname + ", secondname="
				+ secondname + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
	

}
