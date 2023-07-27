package com.blog;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserDao iUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetails = iUserDao.findByUsername(username);
		userDetails.setPassword("{noop}" + userDetails.getPassword());
		List<GrantedAuthorityImpl> grants = iUserDao.getAuthorities(username);
		userDetails.setAuthorities(grants);
		return userDetails;
	}
}