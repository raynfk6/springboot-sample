package tw.example.com.springbootexample.infrastructrue.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tw.example.com.springbootexample.domain.model.Account;
import tw.example.com.springbootexample.domain.repository.AccountRepository;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("user " + username + " not found"));

        return new AccountDetails(account);
    }
}
