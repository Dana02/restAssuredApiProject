package org.example.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

public class RequestSpec {
    private static String baseUrl ="https://create.vista.com";

    public Logger logger() {
        return Logger.getLogger(getClass());
    }

    public String getToken(){
        return "w16819959591kac4UAiVry63zJc29hVN2zaGDyC8";
    }

    public RequestSpecification buildCommonSpec(String baseUrl) {
        return new RequestSpecBuilder().setBaseUri(baseUrl).build();
    }

    public RequestSpecification buildApiSpec(String baseUrl, String basePath) {
        return buildCommonSpec(baseUrl).basePath(basePath);
    }

    public RequestSpecification buildApiSpec(String basePath) {
        return buildCommonSpec(baseUrl).basePath(basePath);
                //.log().all();
    }
}