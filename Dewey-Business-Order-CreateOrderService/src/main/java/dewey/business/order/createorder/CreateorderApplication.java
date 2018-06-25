package dewey.business.order.createorder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class CreateorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateorderApplication.class, args);
    }

    @RequestMapping("/Order/OrderCreate")
    public String OrderCreate(@RequestParam String oid, String token) throws UnknownHostException {
        //Call logic jar

        //demos
        String host = InetAddress.getLocalHost().getHostAddress();

        return "Welcome CRCRFFP to UserLogin Microservice "+ oid +","+ host;
    }

}
