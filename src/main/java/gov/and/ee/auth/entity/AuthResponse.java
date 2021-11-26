package gov.and.ee.auth.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthResponse  {
	private String nombreUsuario;
	private String Correo;
	private String Password;
	
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


    @ElementCollection(fetch = FetchType.EAGER)
    
    private List<String> roles = new ArrayList<>();

	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
