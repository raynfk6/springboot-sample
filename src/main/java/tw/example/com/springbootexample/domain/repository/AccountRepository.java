package tw.example.com.springbootexample.domain.repository;

import java.util.Optional;

import tw.example.com.springbootexample.domain.entity.Account;

public interface AccountRepository {
    public Optional<Account> findByUsername(String username);
}