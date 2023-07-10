package com.dae.ep4.service;

import com.dae.ep4.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(String id);
    public void save(Usuario usuario);
    public void delete(String id);
}
