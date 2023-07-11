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
        return "w1689072228I5TPsF1DPm9oL7b6d2CWfwH0xpQ3F";
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