package com.example.securityApp.security;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.securityApp.dao.UserRepository;
import com.example.securityApp.entities.User;


@Service
public class UserDet implements UserDetailsService {
	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//get the email and the password
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String password = req.getParameter("password");
		
		//fetch from the database 
		User u =userrepo.findByEmailAndPasword(username,password);
		
		//throw the error exception
		if(u==null)throw new UsernameNotFoundException("user not found");
		
		return new UserPrinciple(u);
	}
	
	

}
