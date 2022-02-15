package com.alfred.demo.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.alfred.demo.soap.stub.GetBankResponseType;

import javax.xml.bind.JAXBElement;
public class SoapClient extends WebServiceGatewaySupport {
	public GetBankResponseType getBank(String url, Object request){
		JAXBElement<?> res = (JAXBElement<?>) getWebServiceTemplate().marshalSendAndReceive(url, request);
		return (GetBankResponseType) res.getValue();
	}
}