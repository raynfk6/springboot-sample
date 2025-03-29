package tw.example.com.springbootexample.domain.model;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class Account implements UserDetails {
    // @Autowired
    // private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Long Id;
    private String userName;
    private String password;
    private AccountRole role;

    public Account(String userName, String password, AccountRole role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    /**
     * 用於提供該用戶授權權限集合
     * @return 用戶被授權的權限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
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
