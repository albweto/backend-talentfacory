package com.example.pruebatalent.service;

import com.example.pruebatalent.dao.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pruebatalent.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsServiceImpl implements  UserDetailsService {

    @Autowired
    protected UsuarioService userService;


    /**
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = userService.find(s);
        return (UserDetails) usuario;
    }
}
