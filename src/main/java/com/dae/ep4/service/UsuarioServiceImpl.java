package com.dae.ep4.service;

import com.dae.ep4.entity.Usuario;
import com.dae.ep4.exception.UsuarioNotFoundException;
import com.dae.ep4.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    // Solo uso el findById pero hice el resto de los metodos por costumbre...

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(String id) {
        Usuario usuarioToDelete = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuarioToDelete);
    }
}
