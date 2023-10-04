package com.staragile.Banking.Banking;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MvcBankingController {

	
	@Autowired
	BankingService bankingSvc;
	
	@RequestMapping("/mvchello")
	public String doSomething(){
		return "Hello World!!!";
	}
	
	
	@RequestMapping("/getallbanking")
	public String getAllBanking(HttpServletRequest req, HttpServletResponse res) {
		List<Banking> bankingList = bankingSvc.getBanking();
		req.getSession().setAttribute("bankingList", bankingList);
		return "banking.jsp";
	}
	
	
	
	
	@RequestMapping("/createbanking")
	public String addBanking(HttpServletRequest req, HttpServletResponse res) {
		Banking banking = new Banking();
		banking.setBankingId(req.getParameter("id"));
		banking.setCustomerName(req.getParameter("name"));
		banking.setCustomerAddress(req.getParameter("address"));
		banking.setContactNumber(req.getParameter("contact"));
		bankingSvc.addBanking(banking);
		return getAllBanking(req,res);
	}
	
	@RequestMapping("/updatebanking")
	public String updatebanking(HttpServletRequest req, HttpServletResponse res) {
		Banking banking = new Banking();
		banking.setBankingId(req.getParameter("id"));
		banking.setCustomerName(req.getParameter("name"));
		banking.setCustomerAddress(req.getParameter("address"));
		banking.setContactNumber(req.getParameter("contact"));
		bankingSvc.updateBanking(req.getParameter("id"),banking);
		return getAllBanking(req,res);
	}
	
	@RequestMapping("/viewbanking")
	public String viewbanking(HttpServletRequest req, HttpServletResponse res) {
		Banking banking = new Banking();
		banking.setBankingId(req.getParameter("id"));
		banking.setCustomerName(req.getParameter("name"));
		banking.setCustomerAddress(req.getParameter("address"));
		banking.setContactNumber(req.getParameter("contact"));
		bankingSvc.viewBanking(req.getParameter("id"),banking);
		return getAllBanking(req,res);
	}
	
	@RequestMapping("/deletebanking")
	public String deletebanking(HttpServletRequest req, HttpServletResponse res) {
		bankingSvc.deleteBanking(req.getParameter("id"));
		return getAllBanking(req,res);
	}
}
