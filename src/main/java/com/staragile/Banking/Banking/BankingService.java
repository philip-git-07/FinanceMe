package com.staragile.Banking.Banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingService {
	

	@Autowired
	bankingDAORepository bankingDAORepository;

	//https://github.com/vilasvarghese/microservices/blob/master/training/day1/SpringBoot/4CompanyServiceImplementation.txt
	//continue from line : 115
	public List<Banking> getBanking(){
		/*return Arrays.asList(
			new Policy("1", "Tousif", "Tousif address", "123456789"),
			new Policy("2", "Yashwant", "Yashwant address", "234567891"),
			new Policy("3", "Krishna", "Krishna address", "345678912")
		);*/
		
		List<Banking> bankingList = new ArrayList<Banking>();
		bankingDAORepository.findAll().forEach(bankingList::add);
		return bankingList;
	}
	
	public Optional<Banking> getBanking(String id) {
		return bankingDAORepository.findById(id);
	}
	
	public void addBanking(Banking banking) {
		bankingDAORepository.save(banking);
	}
	
	public void updateBanking(String id, Banking banking) {
		bankingDAORepository.save(banking);
	}
	
	public void viewBanking(String id, Banking banking) {
		bankingDAORepository.save(banking);
	}
	
	public void deleteBanking(String id) {
		bankingDAORepository.deleteById(id);
	}
	
}
