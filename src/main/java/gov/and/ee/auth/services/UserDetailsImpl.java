package gov.and.ee.auth.services;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import gov.and.ee.auth.auth.UserLogin;
import gov.and.ee.auth.entity.AuthResponse;
import gov.and.ee.auth.entity.User;
import gov.and.ee.auth.auth.UserAuthDetails;
import gov.and.ee.auth.feignClient.AuthInterface;
import gov.and.ee.auth.repository.AuthRepository;



@Service
public class UserDetailsImpl implements UserDetailsService {

	 private AuthInterface adminInterface;

	    public UserDetailsImpl(AuthInterface adminInterface) {
	        this.adminInterface = adminInterface;
	    }
	
	 @Autowired 
	 AuthRepository auth;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User  usuario = auth.findByCorreousuario(username);	
		return UserAuthDetails.build(usuario);
	}

/*	@Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User  usuario = auth.findByNombreUsuario(username);	
		return UserAuthDetails.build(usuario);
	 }
	*/
	/*
	 public UserDetails loadUserByUsername(LoginUsuario username) throws UsernameNotFoundException {
		// MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		// parametersMap.add("nombreUsuario", username);
		// User  usuario = restTemplate.postForObject("http://localhost:8081/auth/login", parametersMap,User.class);	
		 AuthResponse adminResponseDTO = adminInterface.fetchAdminByUsername(username)
	                .orElseThrow(() -> new UsernameNotFoundException("Username:" + username + " not found"));

		 System.out.println(adminResponseDTO.getCorreo());
		 
	        List<GrantedAuthority> grantedAuthorities = adminResponseDTO.getRoles()
	                .stream().map(SimpleGrantedAuthority::new)
	                .collect(Collectors.toList());

	        return new org.springframework.security.core.userdetails.User(String.join("-", username, adminResponseDTO.getCorreo()),
	                adminResponseDTO.getPassword(), true, true, true,
	                true, grantedAuthorities);
		 
		 //return UserAuthDetails.build(usuario);
	 }
	
	*/
	

}
