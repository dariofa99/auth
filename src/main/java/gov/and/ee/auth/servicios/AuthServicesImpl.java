package gov.and.ee.auth.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;


import gov.and.ee.auth.model.User;
import gov.and.ee.auth.repository.AuthRepositorio;



@Service
//@Transactional
public class AuthServicesImpl  {

	@Autowired
    AuthRepositorio authRepository;
	


/*
	 @Autowired
	 private PasswordEncoder passwordEncoder;*/

   public User findByCorreo(String correo){
        return authRepository.findByCorreo(correo);
    }
  
    public User  findByNombreUsuario(String nombreUsuario){
        return authRepository.findByNombreUsuario(nombreUsuario);
    }
/*
    public User  save(User usuario){
    	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    	User user = authRepository.save(usuario);
    	if(user.equals(usuario)) {
    		//Rol rol = roleService.findById(1);
    		//user.addRol(rol);
    		return user;
    	}
        return null;
    }

*/
    
}
