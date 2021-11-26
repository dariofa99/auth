package gov.and.ee.auth.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import gov.and.ee.auth.entity.User;
import gov.and.ee.auth.auth.UserAuthDetails;
import gov.and.ee.auth.repository.AuthRepository;



@Service
public class UserDetailsImpl implements UserDetailsService {
	  
	
	 @Autowired 
	 AuthRepository auth;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User  usuario = auth.findByCorreousuario(username);	
		return UserAuthDetails.build(usuario);
	}


}
