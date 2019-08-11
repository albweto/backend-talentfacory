package com.example.pruebatalent.service;


import com.example.pruebatalent.dao.UsuarioRepository;
import com.example.pruebatalent.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    protected  UsuarioRepository  repository;


    @Override
    public Usuario save(Usuario usuario) {
        return this.repository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteuser(int id) {
        this.repository.deleteById((long) id);
    }

    @Override
    public Usuario find(String username) {
        return  repository.findOneByUsername(username);
    }
}
