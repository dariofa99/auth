package gov.and.ee.auth.services;

import javax.servlet.http.HttpServletRequest;

import gov.and.ee.auth.auth.JwtAuth;
import gov.and.ee.auth.auth.UserLogin;
import gov.and.ee.auth.entity.User;

public interface AuthService {
	
	JwtAuth login(UserLogin requestDTO, HttpServletRequest request);
	
	User save(User user);
}
