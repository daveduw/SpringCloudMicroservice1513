package dewey.business.usermanagement.userregisterservice;

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
public class UserRegisterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRegisterServiceApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/UserRegister")
    public String UserRegister(@RequestParam String uid) throws UnknownHostException {
        //Call logic jar
        if (uid.equals("dewey")) {
            Exception ex = new Exception();
        }
        String host = InetAddress.getLocalHost().getHostAddress();
        return "Welcome to UserRegister Microservice " + uid + "," + host + ",port:" + port;
    }
}

