package com.ciclo3.udea.service;

import com.ciclo3.udea.modelos.Usuario;
import com.ciclo3.udea.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {

        return usuarioRepository.findAll();
    }

    //usuario mediante un ID

    public Usuario getUsuario(String id) throws Exception {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new Exception("Usuario No Existe");
        }

    }

    public Usuario saveUsuario(Usuario usuario_param){
        return usuarioRepository.save(usuario_param);
    }
    public Usuario putUsuario(Usuario usuario_param){
        return usuarioRepository.save(usuario_param);
    }
}
