package gov.and.ee.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.and.ee.auth.model.User;





@Repository
public interface AuthRepositorio extends JpaRepository<User, Integer>  {
	//@Query("Select * from Usuarios  where NombreUsuario = :nombreUsuario")
	public User findByNombreUsuario(String nombreUsuario);	
	//@Query("Select * from Usuarios  where Correo = :correo")
	User findByCorreo(@Param("correo")String correo);
	
	
	
	

	
	
	
}
