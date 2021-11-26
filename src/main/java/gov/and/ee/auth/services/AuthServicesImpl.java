package gov.and.ee.auth.services;


import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import gov.and.ee.auth.auth.JwtAuth;
import gov.and.ee.auth.auth.UserLogin;
import gov.and.ee.auth.entity.User;
import gov.and.ee.auth.auth.UserAuthDetails;
import gov.and.ee.auth.feignClient.AuthInterface;
import gov.and.ee.auth.jwt.JwtProvider;
import gov.and.ee.auth.repository.AuthRepository;



@Service
//@Transactional
public class AuthServicesImpl implements AuthService  {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthServicesImpl.class);

    @Autowired
    JwtProvider jwtTokenProvider;

    @Autowired
    private AuthInterface adminInterface;
    
    @Autowired
    private AuthRepository authRepository;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @Override
    public JwtAuth login(UserLogin requestDTO, HttpServletRequest request) {    
        User user = adminInterface.searchAdmin(requestDTO);
        UserAuthDetails userD = UserAuthDetails.build(user);
        String jwt = jwtTokenProvider.generateToken(userD);
        JwtAuth jwtDto = new JwtAuth(jwt, userD.getNombreUsuario(),userD.getAuthorities(),userD.getCorreo());
        return jwtDto;
    }

	@Override
	public User save(User user) {
		user.setUUIDusuario(String.valueOf(UUID.randomUUID()));
		user.setUUIDdocumento(String.valueOf(user.getUUIDdocumento()));
		user.setUUIDpais(String.valueOf(user.getUUIDpais()));
		user.setContrasenausuario(passwordEncoder.encode(user.getContrasenausuario()));
		return authRepository.save(user);
	}

}
