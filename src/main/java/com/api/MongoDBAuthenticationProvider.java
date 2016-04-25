/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

/**
 *
 * @author aaronlieberman
 */  
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jongo.MongoCollection;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Role;
import org.springframework.security.authentication.InternalAuthenticationServiceException;  
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;  
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;  
import org.springframework.security.core.AuthenticationException;  
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoDBAuthenticationProvider implements UserDetailsService {
//public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

//    @Autowired
//    private MongoCollection User;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//    }

//    @Override
//    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        UserDetails loadedUser;
//
//        try {
//            Client client = User.findOne("{#: #}", Client.USERNAME, username).as(Client.class);
//            loadedUser = new User(client.getUsername(), client.getPassword(), client.getRoles());
//        } catch (Exception repositoryProblem) {
//            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
//        }
//
//        if (loadedUser == null) {
//            throw new InternalAuthenticationServiceException(
//                    "UserDetailsService returned null, which is an interface contract violation");
//        }
//        return loadedUser;
//    }
    @Autowired
    private MongoCollection users;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            Client client = users.findOne("{#: #}", Client.USERNAME, username).as(Client.class);
            loadedUser = new User(client.getUsername(), client.getPassword(), client.getRoles());
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    
//    private User user;
//
//    @Autowired
//    UserServiceImpl userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//    throws UsernameNotFoundException {
//
//    try {
//
//    this.user = userService.findByUsername(username);
//
//    boolean enabled = true;
//    boolean accountNonExpired = true;
//    boolean credentialsNonExpired = true;
//    boolean accountNonLocked = true;
//
//    return new User
//    (
//
//    this.user.getUsername(),
//    this.user.getPassword(),
//    enabled,
//    accountNonExpired,
//    credentialsNonExpired,
//    accountNonLocked,
//    getAuthorities()
//    );
//
//    } catch (Exception e) {
//    throw new RuntimeException(e);
//    }
//
//    }
//
//    public Collection getAuthorities() {
//        List authList = getGrantedAuthorities();
//        return authList;
//    }
//
//    public List getGrantedAuthorities() {
//
//        List authorities = new ArrayList();
//        for (Role role : user.getRoles()) {
//        authorities.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//
//        return authorities;
//    }
}
