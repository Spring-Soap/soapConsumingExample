package com.discovering.soapconsumingexample.clients.impl;

import com.discovering.soapconsumingexample.clients.ProductClient;
import com.discovering.soapconsumingexample.wsdl.GetProductRequest;
import com.discovering.soapconsumingexample.wsdl.GetProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
@RequiredArgsConstructor
public class ProductClientSecond implements ProductClient {

    private final WebServiceTemplate webServiceTemplate;

    public GetProductResponse getProduct(String name){
        GetProductRequest request = new GetProductRequest();
        request.setName(name);

        return (GetProductResponse) webServiceTemplate.marshalSendAndReceive(request);
    }
}
