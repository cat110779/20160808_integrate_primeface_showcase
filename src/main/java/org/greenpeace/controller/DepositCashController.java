package org.greenpeace.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import org.atmosphere.cpr.Serializer;
import org.greenpeace.bean.Deposit;
import org.greenpeace.dao.DepositDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "depositcash")
@SessionScoped
public class DepositCashController implements Serializer {
	private static final long serialVersionUID = -8501692478792876840L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DepositCashController.class);

	private List<Deposit> rlist = null;// 叫到前端
	@PostConstruct
	public void depoist() {
		FacesContext context = FacesContext.getCurrentInstance();// session用
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		String account = (String) session.getAttribute("account");// 找要用的session
		DepositDAO dao = new DepositDAO();// 簡
		rlist = dao.queryByMemberAccount(account);

		for (Deposit deposit : rlist) {
			SimpleDateFormat test = new SimpleDateFormat("yyyy/MM/dd ");

			LOGGER.debug(Integer.toString(deposit.getId()));
			LOGGER.debug(Integer.toString(deposit.getDepositCash()));
			LOGGER.debug(test.format(deposit.getDepositTime()));

		}

		

	}

	public List<Deposit> getRlist() {
		return rlist;
	}

	public void setRlist(List<Deposit> rlist) {
		this.rlist = rlist;
	}

	@Override
	public void write(OutputStream arg0, Object arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}
}