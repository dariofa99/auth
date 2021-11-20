package gov.and.ee.auth.servicios;

import gov.and.ee.auth.model.User;

public interface AuthService {
	User  findByNombreUsuario(String nombreUsuario);
	User save();
}
