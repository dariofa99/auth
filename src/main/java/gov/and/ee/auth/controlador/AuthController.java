package gov.and.ee.auth.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.and.ee.auth.auth.JwtAuth;
import gov.and.ee.auth.auth.LoginUsuario;
import gov.and.ee.auth.auth.UserAuthDetails;
import gov.and.ee.auth.jwt.JwtProvider;
import gov.and.ee.auth.model.User;
import gov.and.ee.auth.servicios.AuthServicesImpl;



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
		AuthServicesImpl authService;  
	   
	    
	@PostMapping("/login")
	public ResponseEntity<JwtAuth> login (@Validated @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        
		try {
			if(bindingResult.hasErrors())
				return new ResponseEntity<JwtAuth>(HttpStatus.BAD_REQUEST);			
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword().trim()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = jwtProvider.generateToken(authentication);
	        
	        UserAuthDetails userDetails = (UserAuthDetails)authentication.getPrincipal();
	        
	        
	        JwtAuth jwtDto = new JwtAuth(jwt, userDetails.getNombreUsuario(),userDetails.getAuthorities(),userDetails.getCorreo());
            return new ResponseEntity<JwtAuth>(jwtDto, HttpStatus.OK);        
		} catch (AuthenticationException e) {
			System.out.println("Error in credentials "+e.getMessage());
			e.getMessage();
		}
		return null;
      
    }
	
	/*@PostMapping("/registrar")
	@ResponseBody
	public String guardar(@RequestBody User user) {	
		User us = authService.save(user);
		if(us.equals(user)) {
			return "El usuario se guardo con exito";
		}
		return "Nones";
		
	}*/
	
}
