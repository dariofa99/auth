package gov.and.ee.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
//@EnableZuulProxy
public class AutenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticationServiceApplication.class, args);
	}

}
