package com.blog;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private IUserDao iUserDao;

	@GetMapping("test")
	public String test() {
		System.out.println("Test Test ...");
		return "DATATAATT";
	}

	@GetMapping("/user/me")
	public Principal user(Principal principal) {
		return principal;
	}

	@PostMapping("/saveUserDetails")
	public UserDetailsImpl saveUser(@RequestBody UserDetailsImplDTO userdetailsDto) {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setUsername(userdetailsDto.getUsername());
		userDetailsImpl.setPassword(userdetailsDto.getPassword());
		userDetailsImpl.setEnabled(true);
		userDetailsImpl.setAccountNonExpired(true);
		userDetailsImpl.setAccountNonLocked(true);
		userDetailsImpl.setCredentialsNonExpired(true);
		GrantedAuthorityImpl role = new GrantedAuthorityImpl();
		role.setId(2);
		List<GrantedAuthorityImpl> roleList = new ArrayList<>();
		roleList.add(role);
		userDetailsImpl.setAuthorities(roleList);
		UserDetailsImpl userImpl = iUserDao.save(userDetailsImpl);
		return userImpl;
	}

}
