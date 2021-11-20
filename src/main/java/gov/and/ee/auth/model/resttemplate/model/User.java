package gov.and.ee.auth.model.resttemplate.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
	@Column(name="NumeroID")
	private Integer NumeroID;	
	@Column(name="TipoID")
	private Integer TipoID;	
	@Column(name="PrimerNombre")
	private String PrimerNombre;
	@Column(name="SegundoNombre")
	private String SegundoNombre;
	@Column(name="PrimerApellido")
	private String PrimerApellido;
	@Column(name="SegundoApellido")
	private String SegundoApellido;	
	@Column(name="Movil")
	private Integer Movil;
	@Column(name="Correo")
	private String correo;
	@Column(name="Password")
	private String Password;
	@Column(name="TipoPersona")
	private Integer TipoPersona;
	@Column(name="PaisID")
	private Integer PaisID;
	@Column(name="RolID")
	private Integer RolID;
	@Column(name="nombreUsuario")
	private String nombreUsuario;
	public Integer getNumeroID() {
		return NumeroID;
	}
	public void setNumeroID(Integer numeroID) {
		NumeroID = numeroID;
	}
	public Integer getTipoID() {
		return TipoID;
	}
	public void setTipoID(Integer tipoID) {
		TipoID = tipoID;
	}
	public String getPrimerNombre() {
		return PrimerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		PrimerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return SegundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		SegundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return PrimerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		PrimerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return SegundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		SegundoApellido = segundoApellido;
	}
	public Integer getMovil() {
		return Movil;
	}
	public void setMovil(Integer movil) {
		Movil = movil;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Integer getTipoPersona() {
		return TipoPersona;
	}
	public void setTipoPersona(Integer tipoPersona) {
		TipoPersona = tipoPersona;
	}
	public Integer getPaisID() {
		return PaisID;
	}
	public void setPaisID(Integer paisID) {
		PaisID = paisID;
	}
	public Integer getRolID() {
		return RolID;
	}
	public void setRolID(Integer rolID) {
		RolID = rolID;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
