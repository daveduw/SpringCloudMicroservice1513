package dewey.business.user.userlogin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@EnableEurekaClient
@SpringBootApplication
public class UserLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserLoginApplication.class, args);
    }
    @Value("${server.port}")
    String port;

    @RequestMapping("/UserLogin")
    public String UserRegister(@RequestParam String uid, String Password) throws UnknownHostException {
        //Call logic jar
        String host = InetAddress.getLocalHost().getHostAddress();

        return "Welcome to UserLogin Microservice "+ uid +","+ host+",port:" + port;
    }

}

