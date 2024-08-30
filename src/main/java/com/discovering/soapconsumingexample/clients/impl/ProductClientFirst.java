package com.discovering.soapconsumingexample.clients.impl;

import com.discovering.soapconsumingexample.clients.ProductClient;
import com.discovering.soapconsumingexample.wsdl.GetProductRequest;
import com.discovering.soapconsumingexample.wsdl.GetProductResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Primary
public class ProductClientFirst extends WebServiceGatewaySupport implements ProductClient {

    public GetProductResponse getProduct(String name) {
        GetProductRequest request = new GetProductRequest();
        request.setName(name);

        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
