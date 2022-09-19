package com.ciclo3.udea.controller;

import com.ciclo3.udea.modelos.Usuario;
import com.ciclo3.udea.modelos.UsuarioResponse;
import com.ciclo3.udea.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return new ResponseEntity<List<Usuario>>(
                usuarioService.getUsuarios(),
                HttpStatus.OK
        );
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponse> postUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(new UsuarioResponse("Usuario creado exitosamente",
                usuarioService.saveUsuario(usuario)),HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")

    public ResponseEntity<Object> getUsuario(@PathVariable String id) {

        try {
            Usuario usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario")
    public ResponseEntity<Object> getUsuarios(@RequestParam String id){
        try {
            Usuario usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/usuario")
    public UsuarioResponse putUsuario(@RequestBody Usuario usuario){
        return new UsuarioResponse("usuario actualizado exitosamente", usuarioService.putUsuario(usuario));
    }


}



