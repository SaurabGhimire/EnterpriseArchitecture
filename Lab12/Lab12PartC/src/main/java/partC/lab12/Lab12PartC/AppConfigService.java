package partC.lab12.Lab12PartC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
public class AppConfigService {
    private final AppConfig appConfig;

    @Autowired
    public AppConfigService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void print(){
        System.out.println(appConfig);
    }

}
