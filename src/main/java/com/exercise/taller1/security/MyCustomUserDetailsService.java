package com.exercise.taller1.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.exercise.taller1.model.Userr;
import com.exercise.taller1.repository.UserrRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {

	private UserrRepository userRepository;

	@Autowired
	public MyCustomUserDetailsService(UserrRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Userr> userr = userRepository.findByUserName(username);

		if (userr != null) {
			User.UserBuilder builder = User.withUsername(username).password(userr.get().getUserPassword())
					.roles(userr.get().getType().toString());
			return builder.build();
		} else {
			throw new UsernameNotFoundException("Userr not found.");
		}
	}
}