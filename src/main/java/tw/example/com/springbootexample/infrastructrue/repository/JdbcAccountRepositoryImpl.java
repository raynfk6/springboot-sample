package tw.example.com.springbootexample.infrastructrue.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import tw.example.com.springbootexample.domain.entity.Account;
import tw.example.com.springbootexample.domain.repository.AccountRepository;

@Repository
public class JdbcAccountRepositoryImpl implements AccountRepository {

    @Override
    public Optional<Account> findByUsername(String username) {
        Account account = new Account(
            "user",
            "$2a$10$hZk8/a.dh80g7h8DUtTetu3VjUpNDwbQ5ZZuE8XFaif0KE3a.rvse");
        return Optional.ofNullable(account);
    }

}