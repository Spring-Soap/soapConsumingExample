package com.discovering.soapconsumingexample;

import com.discovering.soapconsumingexample.clients.ProductClient;
import com.discovering.soapconsumingexample.wsdl.GetProductResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapConsumingExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapConsumingExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(ProductClient productClient) {
        return _ -> {
            try {
                GetProductResponse response = productClient.getProduct("sss");
                System.out.println(response.getProduct().getId());
                System.out.println(response.getProduct().getName());
                System.out.println(response.getProduct().getPrice());
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        };
    }
}
