package com.discovering.soapconsumingexample.clients;

import com.discovering.soapconsumingexample.wsdl.GetProductRequest;
import com.discovering.soapconsumingexample.wsdl.GetProductResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ProductClient extends WebServiceGatewaySupport {

    public GetProductResponse getProduct(String name){
        GetProductRequest request = new GetProductRequest();
        request.setName(name);

        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
