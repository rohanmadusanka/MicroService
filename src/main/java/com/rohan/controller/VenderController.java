package com.rohan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.model.Vender;
import com.rohan.repository.VenderRepository;

@RestController
public class VenderController {

	@Autowired
	private VenderRepository venderRepository;

	@RequestMapping(value = "/addVender", method=RequestMethod.POST)
	@ResponseBody
	public String addVender(String companyName, String city, String street, String mobileNo, String officeNo) {
		try {
			Vender vender = new Vender(companyName, city, street, mobileNo, officeNo);
			System.out.println("mile stone 01 "+vender.getCompanyName());
			venderRepository.addVender(vender);
		} catch (Exception e) {
			return "Error when creating vender : " + e.toString();
		}
		return "Vender successfully created....";
	}

	@RequestMapping(value="/deleteVender", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteVender(String id) {
		try {
			Vender vender = new Vender(Long.parseLong(id));
			venderRepository.deleteVender(vender);
		} catch (Exception ex) {
			return "Error when deleting Vender"+ ex.toString();
		}
		return "Successfully deleted";
	}
	
	@RequestMapping(value="/getAllVenders", method=RequestMethod.GET)
	@ResponseBody
	public List<Vender> getAllVenders(){
		try {
			return venderRepository.getAllVenders();
		}catch(Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(value="/updateVender",method=RequestMethod.POST)
	@ResponseBody
	public String updateVender(Vender vender) {
		try {
			System.out.println("Update method fired...." +vender.getCompanyName()+"   "+vender.getMobileno()+"  "+vender.getOfficeno());
			venderRepository.updateVender(vender);
			return "Successfully updated.";
		}catch(Exception e) {
			return "Error when deleting vender "+e.toString();
		}
	}
	
}
