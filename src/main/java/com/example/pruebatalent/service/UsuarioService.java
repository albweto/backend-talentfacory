package com.example.pruebatalent.service;

import com.example.pruebatalent.modelo.Usuario;

import java.util.List;

public interface UsuarioService {

    /**
     *
      * @param usuario
     * @return
     */
    Usuario save(Usuario usuario);

    /**
     *
     * @return
     */
    List<Usuario> findAll();

    /**
     *
     * @param id
     */
    void deleteuser(int id);

    /**
     *
     * @param username
     * @return
     */
    Usuario find(String username);
}
