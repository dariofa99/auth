package gov.and.ee.auth.servicios;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import gov.and.ee.auth.auth.UserAuthDetails;
import gov.and.ee.auth.model.User;
import gov.and.ee.auth.repository.AuthRepositorio;



@Service
public class UserDetailsImpl implements UserDetailsService {

	
	 @Autowired 
	 AuthRepositorio auth;
	 
	 @Autowired
	 RestTemplate restTemplate;

	/*@Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User  usuario = auth.findByNombreUsuario(username);	
		return UserAuthDetails.build(usuario);
	 }*/
	 
	 @Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		 parametersMap.add("nombreUsuario", username);
		 User  usuario = restTemplate.postForObject("http://localhost:8081/auth/login", parametersMap,User.class);	
		return UserAuthDetails.build(usuario);
	 }
	
	
	

}
