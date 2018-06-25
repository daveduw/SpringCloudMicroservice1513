package dewey.framework.usermanagement.wechartloginservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class UserRegisterServiceLocal {

    @FeignClient(value = "USERREGISTERSERVICE")
    public interface RegisterUser {
        @RequestMapping(value = "/UserRegister",method = RequestMethod.GET)
        String RegisterUser(@RequestParam(value = "uid") String name);
    }
}
