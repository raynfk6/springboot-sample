package tw.example.com.springbootexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tw.example.com.springbootexample.repository.UserRepository;

public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // use userRepository fill the values
        UserDetails user = User
            .withUsername("user")
            .password("$2a$10$hZk8/a.dh80g7h8DUtTetu3VjUpNDwbQ5ZZuE8XFaif0KE3a.rvse")  //user
            .authorities("PG")  // roles or authorities?
            .build();
        return user;
    }
    
}
