package com.example.pruebatalent.dao;

import com.example.pruebatalent.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     *
     * @param usuario
     * @return
     */
    @SuppressWarnings("unchecked")
    Usuario save(Usuario usuario);

    /**
     *
     * @param username
     * @return
     */
    Usuario findOneByUsername(String username);
}
