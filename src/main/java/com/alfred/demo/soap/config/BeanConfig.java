package com.alfred.demo.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.alfred.demo.soap.client.SoapClient;

@Configuration
public class BeanConfig {
	@Bean
	public Jaxb2Marshaller marshaller()  {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.alfred.demo.soap.stub");
		return marshaller;
	}
	@Bean
	public SoapClient soapConnector(Jaxb2Marshaller marshaller) {
		SoapClient client = new SoapClient();
		client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}