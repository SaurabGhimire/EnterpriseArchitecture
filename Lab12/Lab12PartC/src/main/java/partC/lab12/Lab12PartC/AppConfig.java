package partC.lab12.Lab12PartC;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppConfig {
    String applicationName;
    String version;
    String serverUrl;
    String userFirstName;
    String userLastName;
    String userUserName;
    List<String> countries;

    AppConfig(){
        System.out.println("Inside app config");
    }



    @Override
    public String toString() {
        return "AppConfig{" +
                "applicationName='" + applicationName + '\'' +
                ", version='" + version + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userUserName='" + userUserName + '\'' +
                ", countries=" + countries +
                '}';
    }
}
