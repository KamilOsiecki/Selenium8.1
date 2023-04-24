package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnvironmentModel {

    boolean active;

    public boolean isActive() {
        return active;
    }

    Map<String, Object> environmentModelProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvironmentModelProperties(String key, Object value) {
        environmentModelProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getEnvironmentModelProperties() {
        return environmentModelProperties;
    }
}