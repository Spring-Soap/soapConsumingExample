package com.discovering.soapconsumingexample.configurations;

import com.discovering.soapconsumingexample.clients.impl.ProductClientFirst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class ProductConfiguration
{

    // This bean responsible on marshalling and unmarshalling XML to Java objects
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.discovering.soapconsumingexample.wsdl");
        return marshaller;
    }

    @Bean
    public ProductClientFirst productClient(Jaxb2Marshaller marshaller) {
        ProductClientFirst client = new ProductClientFirst();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


    // This bean responsible on sending and receiving the request
    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate  w = new WebServiceTemplate();
        w.setDefaultUri("http://localhost:8080/ws");
        w.setMarshaller(marshaller);
        w.setUnmarshaller(marshaller);
        return w;
    }
}
