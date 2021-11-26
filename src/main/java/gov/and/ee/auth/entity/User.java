package gov.and.ee.auth.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="TBLUsuario")
public class User {
	
	@Id
	@Column(name="UUIDusuario")
	private String UUIDusuario;	
	@Column(name="Nombreusuario")
	private String nombreusuario;	
	@Column(name="Apellidousuario")
	private String Apellidousuario;	
	@Column(name="Correousuario")
	private String correousuario;	
	@Column(name="Contrasenausuario")
	private String Contrasenausuario;	
	@Column(name="Telefonousuario")
	private String Telefonousuario;
	@Column(name="Estadousuario")
	private String Estadousuario;
	@Column(name="Numeroidentificacionu")
	private String Numeroidentificacionu;	
	@Column(name="UUIDdocumento")	
	private String UUIDdocumento;	
	@Column(name="UUIDpais")	
	private String UUIDpais;
	
	
	
	public User() {
		
	}
	public User(String uUIDusuario, String nombreusuario, String apellidousuario, String correousuario,
			String contrasenausuario, String telefonousuario, String estadousuario, String numeroidentificacionu,
			String uUIDdocumento, String uUIDpais) {
	
		UUIDusuario = uUIDusuario;
		this.nombreusuario = nombreusuario;
		Apellidousuario = apellidousuario;
		this.correousuario = correousuario;
		Contrasenausuario = contrasenausuario;
		Telefonousuario = telefonousuario;
		Estadousuario = estadousuario;
		Numeroidentificacionu = numeroidentificacionu;
		UUIDdocumento = uUIDdocumento;
		UUIDpais = uUIDpais;
	}
	public String getUUIDusuario() {
		return UUIDusuario;
	}
	public void setUUIDusuario(String string) {
		UUIDusuario = string;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getApellidousuario() {
		return Apellidousuario;
	}
	public void setApellidousuario(String apellidousuario) {
		Apellidousuario = apellidousuario;
	}
	public String getCorreousuario() {
		return correousuario;
	}
	public void setCorreousuario(String correousuario) {
		this.correousuario = correousuario;
	}
	public String getContrasenausuario() {
		return Contrasenausuario;
	}
	public void setContrasenausuario(String contrasenausuario) {
		Contrasenausuario = contrasenausuario;
	}
	public String getTelefonousuario() {
		return Telefonousuario;
	}
	public void setTelefonousuario(String telefonousuario) {
		Telefonousuario = telefonousuario;
	}
	public String getEstadousuario() {
		return Estadousuario;
	}
	public void setEstadousuario(String estadousuario) {
		Estadousuario = estadousuario;
	}
	public String getNumeroidentificacionu() {
		return Numeroidentificacionu;
	}
	public void setNumeroidentificacionu(String numeroidentificacionu) {
		Numeroidentificacionu = numeroidentificacionu;
	}
	public String getUUIDdocumento() {
		return UUIDdocumento;
	}
	public void setUUIDdocumento(String string) {
		UUIDdocumento = string;
	}
	public String getUUIDpais() {
		return UUIDpais;
	}
	public void setUUIDpais(String string) {
		UUIDpais = string;
	}
	
	
	
}
