package com.roche.beneficios.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.User;
import com.roche.beneficios.entity.UserRole;
import com.roche.beneficios.model.UserModel;

@Component("userConverter")
public class UserConverter {
	
	public User modelToUser(UserModel in) {
		User out = new User();
		UserRole uRol = new UserRole();
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		Set<UserRole> userRoles = new HashSet<>();
		
		uRol.setUser(out);
		uRol.setRole(in.getRole());
		
		userRoles.add(uRol);
		
		out.setUsername(in.getUsername());
		out.setPassword(pe.encode(in.getPassword()));
		out.setUserRole(userRoles);
		out.setEnable(in.isEnable());
		
		return out;
	}
}
