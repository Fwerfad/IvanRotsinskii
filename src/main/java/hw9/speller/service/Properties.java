package hw9.speller.service;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class Properties {
    private java.util.Properties props;
    private Map<Integer, String> endpoints;

    @SneakyThrows
    public Properties() {
        props = new java.util.Properties();
        String propFileName = "hw9/test.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        endpoints = new HashMap<>();
        endpoints.put(1, "textEndpoint");
        endpoints.put(2, "textsEndpoint");
    }

    public java.util.Properties getProperties() {
        return props;
    }

    public String getEndpoint(int index) {
        return endpoints.get(index);
    }
}
