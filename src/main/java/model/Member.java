package model;

import java.io.Serializable;
import javax.persistence.*;

import bean.Login;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MEMBER database table.
 * 
 */
@Entity
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String account;

	private BigDecimal cash;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	private String email;

	@Column(name="M_TYPE")
	private String mType;

	private String password;

	//bi-directional many-to-one association to Customer
	
	private List<Customer> customers;

	//bi-directional many-to-one association to Deposit

	private List<Deposit> deposits;

	//bi-directional many-to-one association to Order
	@Column(name="")
	private List<Order> orders;

	public Member() {
		Login login = new Login();
		
	}

	

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getmType() {
		return mType;
	}


	public void setmType(String mType) {
		this.mType = mType;
	}





	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BigDecimal getCash() {
		return this.cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMType() {
		return this.mType;
	}

	public void setMType(String mType) {
		this.mType = mType;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setMember(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setMember(null);

		return customer;
	}

	public List<Deposit> getDeposits() {
		return this.deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

	public Deposit addDeposit(Deposit deposit) {
		getDeposits().add(deposit);
		deposit.setMember(this);

		return deposit;
	}

	public Deposit removeDeposit(Deposit deposit) {
		getDeposits().remove(deposit);
		deposit.setMember(null);

		return deposit;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setMember(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setMember(null);

		return order;
	}

}