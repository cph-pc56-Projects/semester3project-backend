package org.cba.model.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.cba.model.entities.finder.UserFinder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 11/13/2017.
 */
@JsonFilter("SimpleUserFilter")
@Entity
public class User implements Principal{

    public static final UserFinder find = new UserFinder();
    @Id
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String salt;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String getName() {
        return username;
    }
}
