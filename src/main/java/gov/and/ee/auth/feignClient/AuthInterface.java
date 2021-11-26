package gov.and.ee.auth.feignClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.and.ee.auth.auth.UserLogin;
import gov.and.ee.auth.entity.AuthResponse;
import gov.and.ee.auth.entity.User;
import gov.and.ee.auth.auth.UserAuthDetails;

@FeignClient(name = "USER-SERVICE")
@Service
@Controller
public interface AuthInterface {

    @RequestMapping(value = "/user/find")
    Optional<AuthResponse> fetchAdminByUsername(UserLogin username);
    @RequestMapping(value = "/user/login")
	User searchAdmin(UserLogin loginRequestDTO);
}