package partC.lab12.Lab12PartC;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.config")
@Validated
public class AppConfig {
    @NotBlank
    String applicationName;
    @NotBlank
    String version;
    @NotBlank

    String serverUrl;
    String userFirstName;
    String userLastName;
    @NotBlank
    @Size(min = 8, max = 15)
    String userUserName;
    @NotBlank
    @Size(min = 8, max = 15)
    String userPassword;
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
                ", userPassword='" + userPassword + '\'' +
                ", countries=" + countries +
                '}';
    }
}
