package com.example.aguis.etecapp.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aguis on 7/5/2017.
 */

public class RequestPackage {

    private String uri;
    private String method = "GET";
    private ArrayList<String> messageAttributes = new ArrayList<>();
    private ArrayList<String> messageValues = new ArrayList<>();
    private Map<String, String> params = new HashMap<>();

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setParam(String key, String value) {
        params.put(key, value);
    }

    public ArrayList<String> getMessageAttributes() {
        return messageAttributes;
    }

    public void setMessageAttributes(String... attributes) {
        for (int i = 0; i < attributes.length; i++) {
            messageAttributes.add(attributes[i]);
        }
    }

    public ArrayList<String> getMessageValues() {
        return messageValues;
    }

    public void setMessageValues(String... values) {
        for (int i = 0; i < values.length; i++) {
            messageValues.add(values[i]);
        }
    }
}
