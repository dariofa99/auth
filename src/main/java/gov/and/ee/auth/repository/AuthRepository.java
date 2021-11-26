package gov.and.ee.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.and.ee.auth.entity.User;





@Repository
public interface AuthRepository extends JpaRepository<User, Integer>  {
	//@Query("Select * from Usuarios  where NombreUsuario = :nombreUsuario")
	public User findByNombreusuario(String nombreUsuario);	
	//@Query("Select * from Usuarios  where Correo = :correo")
	User findByCorreousuario(@Param("correo")String correo);
	
	
	

	
	
	
}
