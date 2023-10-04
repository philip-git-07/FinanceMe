package com.staragile.Banking.Banking;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController {

    @Autowired
    BankingService BankingSvc;

    @RequestMapping("hello")
    public String doSomething() {
        return "Hello World";
    }
    
    @RequestMapping("/seeddata")
	public String getBanking(){
		System.out.println("Inside seeddata");
		Banking p1 = new Banking("1", "ameen", "Ameen Address", "9876543210");
		BankingSvc.addBanking(p1);
		
		p1 = new Banking("2", "naseef", "Naseef Address", "1234567893");
		BankingSvc.addBanking(p1);
		return "Data seeded successfully!!!";
    }    
    
    

    @RequestMapping("/Banking/{id}")
    public Optional<Banking> getBanking(@PathVariable String id) {
        System.out.println("Inside getBanking");
        return BankingSvc.getBanking(id);
    }

    @RequestMapping("/Banking")
    public List<Banking> getPolicies() {
        return BankingSvc.getBanking();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Banking")
    public String addBanking(@RequestBody Banking Banking) {
        BankingSvc.addBanking(Banking);
        return "Successfully added!!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Banking/{id}")
    public String updateBanking(@RequestBody Banking Banking, @PathVariable String id) {
        BankingSvc.updateBanking(id, Banking);
        return "Updated successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Banking/{id}")
    public String deleteBanking(@PathVariable String id) {
        BankingSvc.deleteBanking(id);
        return "Updated successfully";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/Banking/{id}")
    public Optional<Banking> getBankingById(@PathVariable String id) {
        System.out.println("Inside getBankingById");
        return BankingSvc.getBanking(id);
    }
}
