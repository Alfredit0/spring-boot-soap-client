package com.alfred.demo.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alfred.demo.soap.client.SoapClient;
import com.alfred.demo.soap.stub.DetailsType;
import com.alfred.demo.soap.stub.GetBankResponseType;
import com.alfred.demo.soap.stub.GetBankType;
import com.alfred.demo.soap.stub.ObjectFactory;



@RestController
@RequestMapping("/")
public class BlzController {

	@Autowired
	private SoapClient soapClient;

	@GetMapping
	public DetailsType sum(@RequestParam String code) {
		ObjectFactory objectFactory = new ObjectFactory();
		GetBankType type = new GetBankType();
		type.setBlz(code);

		GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",
				objectFactory.createGetBank(type));
		return response.getDetails();
	}
}