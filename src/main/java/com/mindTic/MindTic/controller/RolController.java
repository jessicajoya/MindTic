package com.MindTic.MindTic.controller;

import com.MindTic.MindTic.models.Rol;
import com.MindTic.MindTic.models.RolResponse;
import com.MindTic.MindTic.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolController {

    @Autowired
    private RolService RolService;

    @GetMapping("/Rols")
    public ResponseEntity<List<Rol>> getRols() {
        return new ResponseEntity<List<Rol>>(
                RolService.getRol(),
                HttpStatus.OK
        );
    }

    @GetMapping("/Rol/{id}")
    public ResponseEntity<Object> getRols(@PathVariable Integer id) {
        try {
            Rol Rol= RolService.getRol(id);
            return new ResponseEntity<>(Rol, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Rol")
    public ResponseEntity<Object> getRol(@RequestParam Integer id) {
        try {
            Rol Rol = RolService.getRol(id);
            return new ResponseEntity<>(Rol, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Rol")
    public ResponseEntity<RolResponse> postRol(@RequestBody Rol Rol) {
        return new ResponseEntity<>(new RolResponse("Rol creado exitosamente",
                RolService.saveRol(Rol)), HttpStatus.OK);
    }

    @PutMapping("/Rol")
    public ResponseEntity<RolResponse> putRol(@RequestBody Rol Rol) {
        return new ResponseEntity<>(new RolResponse("Rol Actualizado Exitosamente",
                RolService.putRol(Rol)), HttpStatus.OK);
    }

    @PatchMapping("/Rol/{id}")
    public ResponseEntity<RolResponse> patch(@RequestBody Rol Rol, @PathVariable Integer id){
        try {
            return new ResponseEntity<>(
                    new RolResponse("Actualizacion Exitosa!!",
                            RolService.patchRol(Rol,id)),
                            HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new RolResponse(e.getMessage(),null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("/Rol/{id}")
    public ResponseEntity<RolResponse> delete(@PathVariable Integer id){
        return new ResponseEntity<>(
                new RolResponse(RolService.delete(id),null ), HttpStatus.OK
        );
    }
}
