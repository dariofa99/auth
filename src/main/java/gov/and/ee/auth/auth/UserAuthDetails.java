package gov.and.ee.auth.auth;


import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.security.core.userdetails.UserDetails;

import gov.and.ee.auth.entity.User;





public class UserAuthDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nombre;
	private String nombreUsuario;
	private String Correo;
	private String Password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserAuthDetails() {
		
	}

	public UserAuthDetails(String nombreUsuario,  String password,String correo,
			Collection<? extends GrantedAuthority> authorities) {	
		
		this.nombreUsuario = nombreUsuario;		
		this.Password = password;
		this.Correo = correo;
		this.authorities = authorities;
	}

	public static UserAuthDetails build(User usuario){     
		
		List<GrantedAuthority> authorities =
				AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
		
		
		return new UserAuthDetails(
				usuario.getNombreusuario()
				,usuario.getContrasenausuario()
				,usuario.getCorreousuario(),
				authorities);
		    
    }
	
	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		this.Correo = correo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getPrimerNombre() {
		return nombreUsuario;
	}
	public void setPrimerNombre(String primerNombre) {
		nombreUsuario = primerNombre;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	

	
}
