package gov.and.ee.auth.auth;


public class UserLogin {
	//private String nombreUsuario;
	private String Correo;
	private String Password;
	
	
	
	public UserLogin() {
		
	}
	public UserLogin(String nombreUsuario, String correo, String password) {
		
		//this.nombreUsuario = nombreUsuario;
		Correo = correo;
		Password = password;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	/*public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}*/
	public String getEmail() {
		return Correo;
	}
	public void setEmail(String email) {
		this.Correo = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	/*public static LoginUsuario builder(String username, String emailAddress) {
		// TODO Auto-generated method stub
		return new LoginUsuario(username,emailAddress);
	}*/
	
	
}
