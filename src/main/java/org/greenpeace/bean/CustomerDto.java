package org.greenpeace.bean;

import java.io.Serializable;

public class CustomerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2976350541930809485L;
	
	private Customer po ;
	
	private boolean ok ;

	public Customer getPo() {
		return po;
	}

	public void setPo(Customer po) {
		this.po = po;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
