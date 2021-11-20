package gov.and.ee.auth.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtAuth {
	  private String token;
	    private String bearer = "Bearer";
	    private String nombreUsuario;
	    private String Correo;
	   private  Collection<? extends GrantedAuthority> authorities;
	    

	   public JwtAuth(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities, String correo) {
	        this.token = token;
	        this.nombreUsuario = nombreUsuario;
	        this.authorities = authorities;
	        this.Correo = correo;
	    }

		public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

	    public String getBearer() {
	        return bearer;
	    }

	    public void setBearer(String bearer) {
	        this.bearer = bearer;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

		public String getCorreo() {
			return Correo;
		}

		public void setCorreo(String correo) {
			Correo = correo;
		}

		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
			this.authorities = authorities;
		}

	  
}
