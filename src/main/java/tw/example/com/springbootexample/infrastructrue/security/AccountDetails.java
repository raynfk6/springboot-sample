package tw.example.com.springbootexample.infrastructrue.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tw.example.com.springbootexample.domain.dataclass.AccountRole;
import tw.example.com.springbootexample.domain.model.Account;

public class AccountDetails implements UserDetails {
    private final Account account;

    public AccountDetails(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    /**
     * 用於提供該用戶授權權限集合
     * @return 用戶被授權的權限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        
        for (AccountRole role : this.account.getRoles()) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
            authorities.add(authority);
        }

        return authorities;
    }

    @Override
    public String getUsername() {
        return this.account.getUsername();
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }

    /**
     * 用來判斷使用者的帳戶是否過期
     * @return 如果帳戶已過期，返回false，表示使用者不應該被授權，反之則true。
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用來判斷使用者的帳戶是否被鎖定
     * @return 如果帳戶被鎖定，返回false，表示使用者不應該被授權。
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用來判斷使用者的認證信息是否過期，例如密碼是否過期
     * @return 如果認證信息已過期，返回false，表示使用者不應該被授權。
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用來判斷使用者是否啟用，如果使用者已被禁用
     * @return 返回false，表示使用者不應該被授權。
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
