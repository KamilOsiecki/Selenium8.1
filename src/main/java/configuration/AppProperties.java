package configuration;

import lombok.extern.slf4j.Slf4j;
import models.Browser;
import models.EnvironmentModel;

import java.util.List;
import java.util.Map;

@Slf4j
public class AppProperties {
    YamlReader yamlReader = new YamlReader();
    private Browser browser;
    private List<EnvironmentModel> environmentModelList;

    private AppProperties() {
        setBrowserProperties();
        setEnvironmentProperties();
    }

    public static AppProperties getInstance() {
        return AppProperties.AppPropertiesSingleton.INSTANCE;
    }

    private void setEnvironmentProperties() {
        environmentModelList = yamlReader.getConfig().getEnvironment().getEnvironmentsProperties();
        for (EnvironmentModel environmentModel : environmentModelList) {
            if (environmentModel.isActive()) {
                Map<String, Object> envProperties = environmentModel.getEnvironmentModelProperties();
                for (Map.Entry entry : envProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    log.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            log.info("Load browser properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }
}