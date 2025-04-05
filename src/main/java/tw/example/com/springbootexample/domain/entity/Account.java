package tw.example.com.springbootexample.domain.entity;

import java.util.HashSet;
import java.util.Set;

import tw.example.com.springbootexample.domain.dataclass.AccountRole;
import tw.example.com.springbootexample.domain.dataclass.Project;

public class Account {
    private Long id;
    private String username;
    private String password;
    private Set<AccountRole> roles;
    private Set<Project> projects;

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>();
        this.projects = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AccountRole> getRoles() {
        return this.roles;
    }

    public void addRole(AccountRole role) {
        this.roles.add(role);
    }

    public void removeRole(AccountRole role) {
        this.roles.remove(role);
    }

    public Set<Project> getProjects() {
        return this.projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
    }
}
