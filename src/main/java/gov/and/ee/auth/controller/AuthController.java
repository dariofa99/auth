package gov.and.ee.auth.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import gov.and.ee.auth.auth.JwtAuth;
import gov.and.ee.auth.auth.UserAuthDetails;
import gov.and.ee.auth.auth.UserLogin;
import gov.and.ee.auth.entity.User;
import gov.and.ee.auth.jwt.JwtProvider;
import gov.and.ee.auth.services.AuthService;
import gov.and.ee.auth.services.UserDetailsImpl;



@RestController
@RequestMapping("/auth")
@ResponseBody
@CrossOrigin
public class AuthController {
 
	
	 	@Autowired
	    AuthenticationManager authenticationManager;
	    @Autowired
	    JwtProvider jwtProvider;	    
	    @Autowired
		AuthService loginService;  
	    @Autowired
	    UserDetailsImpl userDet;
	    
	    
	    
	    @PostMapping(value = "/login/auth")	   
	    public ResponseEntity<JwtAuth> loginUser(@RequestBody UserLogin requestDTO, HttpServletRequest request, BindingResult bindingResult) {
	    	try {
				if(bindingResult.hasErrors())
					return new ResponseEntity<JwtAuth>(HttpStatus.BAD_REQUEST);						
				JwtAuth jwtDto = loginService.login(requestDTO, request);
			    return new ResponseEntity<JwtAuth>(jwtDto, HttpStatus.OK);        
			} catch (AuthenticationException e) {
				System.out.println("Error in credentials "+e.getMessage());
				e.getMessage();
			}
			return null;
	    }
	    
	    
	@PostMapping("/login")
	public ResponseEntity<JwtAuth> login (@Validated @RequestBody UserLogin loginUsuario, BindingResult bindingResult){     
		System.out.println(loginUsuario.getCorreo());
		try {
			if(bindingResult.hasErrors())
				return new ResponseEntity<JwtAuth>(HttpStatus.BAD_REQUEST);			
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getCorreo(), loginUsuario.getPassword().trim()));
	        UserAuthDetails userDetails = (UserAuthDetails) userDet.loadUserByUsername(loginUsuario.getEmail());
    		SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = jwtProvider.generateToken(userDetails);    
	      JwtAuth jwtDto = new JwtAuth(jwt, userDetails.getNombreUsuario(),userDetails.getAuthorities(),userDetails.getCorreo());
          return new ResponseEntity<JwtAuth>(jwtDto, HttpStatus.OK);        
		} catch (AuthenticationException e) {
			System.out.println("Error in credentials "+e.getMessage());
			e.getMessage();
		}
		return null;
      
    }
	
	@PostMapping("/register")
	@ResponseBody
	public String guardar(@RequestBody User user) {	
		User us = loginService.save(user);		
			return "El usuario se guardo con exito";		
	}
	
}
