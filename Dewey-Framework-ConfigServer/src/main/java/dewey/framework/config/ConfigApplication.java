package dewey.framework.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {


    public static void main(String[] args) {

        args = new String[1];
        // 使用native不可以使用spring.profiles.active的方式使用native模式
        //  args[0] = "--spring.profiles.active=nativesimple";
        args[0] = "--spring.config.name=application-nativesimple";
        SpringApplication.run(ConfigApplication.class, args);
    }
}
