package com.roche.beneficios.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.converter.UserConverter;
import com.roche.beneficios.entity.User;
import com.roche.beneficios.model.UserModel;
import com.roche.beneficios.repository.UserRepository;
import com.roche.beneficios.repository.UserRoleRepository;
import com.roche.beneficios.services.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	@Override
	public UserModel insertarUsuario(UserModel nuevoUsuario) {
		User nUser = userConverter.modelToUser(nuevoUsuario);
		
		userRepository.save(nUser);
		userRoleRepository.save(nUser.getUserRole());
		
		return null;
	}

}
