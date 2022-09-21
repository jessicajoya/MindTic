package com.MindTic.MindTic.controller;

import com.MindTic.MindTic.models.Empresas;
import com.MindTic.MindTic.models.EmpresasResponse;
import com.MindTic.MindTic.service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresasController {

    @Autowired
    private EmpresasService EmpresasService;

    @GetMapping("/Empresas")
    public ResponseEntity<List<Empresas>> getEmpresass() {
        return new ResponseEntity<List<Empresas>>(
                EmpresasService.getEmpresas(),
                HttpStatus.OK
        );
    }

    @GetMapping("/Empresas/{id}")
    public ResponseEntity<Object> getEmpresass(@PathVariable Integer id) {
        try {
            Empresas Empresas= EmpresasService.getEmpresas(id);
            return new ResponseEntity<>(Empresas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Empresa")
    public ResponseEntity<Object> getEmpresas(@RequestParam Integer id) {
        try {
            Empresas Empresas = EmpresasService.getEmpresas(id);
            return new ResponseEntity<>(Empresas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Empresas")
    public ResponseEntity<EmpresasResponse> postEmpresas(@RequestBody Empresas Empresas) {
        return new ResponseEntity<>(new EmpresasResponse("Empresas creado exitosamente",
                EmpresasService.saveEmpresas(Empresas)), HttpStatus.OK);
    }

    @PutMapping("/Empresas")
    public ResponseEntity<EmpresasResponse> putEmpresas(@RequestBody Empresas Empresas) {
        return new ResponseEntity<>(new EmpresasResponse("Empresas Actualizado Exitosamente",
                EmpresasService.putEmpresas(Empresas)), HttpStatus.OK);
    }

    @PatchMapping("/Empresas/{id}")
    public ResponseEntity<EmpresasResponse> patch(@RequestBody Empresas Empresas, @PathVariable Integer id){
        try {
            return new ResponseEntity<>(
                    new EmpresasResponse("Actualizacion Exitosa!!",
                            EmpresasService.patchEmpresas(Empresas,id)),
                            HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new EmpresasResponse(e.getMessage(),null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("/Empresas/{id}")
    public ResponseEntity<EmpresasResponse> delete(@PathVariable Integer id){
        return new ResponseEntity<>(
                new EmpresasResponse(EmpresasService.delete(id),null ), HttpStatus.OK
        );
    }
}
