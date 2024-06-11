package partC.lab12.Lab12PartC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppConfigService {
    @Autowired
    AppConfig appConfig;

    public void print(){
        System.out.println(appConfig);
    }

}
