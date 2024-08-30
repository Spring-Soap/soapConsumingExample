package com.discovering.soapconsumingexample.clients;

import com.discovering.soapconsumingexample.wsdl.GetProductResponse;

public interface ProductClient {
    GetProductResponse getProduct(String name);
}
