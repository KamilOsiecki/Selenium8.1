package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Environment {

    Map<String, EnvironmentModel> environmentsProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvironmentProperties(String key, EnvironmentModel environmentModel) {
        environmentsProperties.put(key, environmentModel);
    }

    @JsonAnyGetter
    public List<EnvironmentModel> getEnvironmentsProperties() {
        return environmentsProperties.values().stream().toList();
    }
}