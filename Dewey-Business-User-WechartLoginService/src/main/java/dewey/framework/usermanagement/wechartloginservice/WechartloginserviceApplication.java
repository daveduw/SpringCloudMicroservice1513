package dewey.framework.usermanagement.wechartloginservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.RequestContext;

@RestController
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class WechartloginserviceApplication {

    private static final Logger log = LoggerFactory.getLogger(WechartloginserviceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WechartloginserviceApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate initRestTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping("/WeChartLogin")
    @HystrixCommand(fallbackMethod = "OnBreak")
//http://localhost:10003/hystrix input http://localhost:10003/hystrix.stream
    public String weChartLogin(@RequestParam String wid) {
        //Call logic jar
//        RestTemplate restTemplate = new RestTemplate();
//        RequestContext
        ResponseEntity<String> responseEntity = initRestTemplate.getForEntity("http://USERREGISTERSERVICE/UserRegister?uid=" + wid, String.class);

        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();

    }

    public String OnBreak(String name) {
        return name + "系统繁忙！";
    }

    @Autowired
    UserRegisterServiceLocal.RegisterUser userRegisterServiceLocal;

    @RequestMapping(value = "/WeChartLoginFeign",method = RequestMethod.GET)
    public String weChartLoginFeign(@RequestParam String uid){
        return userRegisterServiceLocal.RegisterUser(uid);
    }


}
