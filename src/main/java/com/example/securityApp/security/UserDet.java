package com.example.securityApp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securityApp.dao.UserRepository;
import com.example.securityApp.entities.User;


@Service
public class UserDet implements UserDetailsService {
	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u =userrepo.findByEmail(username);
		
		if(u==null)throw new UsernameNotFoundException("user not found");
		
		return new UserPrinciple(u);
	}
	
	

}
