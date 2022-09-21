package com.MindTic.MindTic.controller;

import com.MindTic.MindTic.models.Empleados;
import com.MindTic.MindTic.models.EmpleadosResponse;
import com.MindTic.MindTic.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadosController {

    @Autowired
    private EmpleadosService EmpleadosService;

    @GetMapping("/Empleados")
    public ResponseEntity<List<Empleados>> getEmpleados() {
        return new ResponseEntity<List<Empleados>>(
                EmpleadosService.getEmpleados(),
                HttpStatus.OK
        );
    }

    @GetMapping("/Empleados/{id}")
    public ResponseEntity<Object> getEmpleado(@PathVariable Integer id) {
        try {
            Empleados Empleados= EmpleadosService.getEmpleados(id);
            return new ResponseEntity<>(Empleados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Empleado")
    public ResponseEntity<Object> getEmpleados(@RequestParam Integer id) {
        try {
            Empleados Empleados = EmpleadosService.getEmpleados(id);
            return new ResponseEntity<>(Empleados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Empleados")
    public ResponseEntity<EmpleadosResponse> postEmpleados(@RequestBody Empleados Empleados) {
        return new ResponseEntity<>(new EmpleadosResponse("Empleados creado exitosamente",
                EmpleadosService.saveEmpleados(Empleados)), HttpStatus.OK);
    }

    @PutMapping("/Empleados")
    public ResponseEntity<EmpleadosResponse> putEmpleados(@RequestBody Empleados Empleados) {
        return new ResponseEntity<>(new EmpleadosResponse("Empleados Actualizado Exitosamente",
                EmpleadosService.putEmpleados(Empleados)), HttpStatus.OK);
    }

    @PatchMapping("/Empleados/{id}")
    public ResponseEntity<EmpleadosResponse> patch(@RequestBody Empleados Empleados, @PathVariable Integer id){
        try {
            return new ResponseEntity<>(
                    new EmpleadosResponse("Actualizacion Exitosa!!",
                            EmpleadosService.patchEmpleados(Empleados,id)),
                            HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new EmpleadosResponse(e.getMessage(),null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("/Empleados/{id}")
    public ResponseEntity<EmpleadosResponse> delete(@PathVariable Integer id){
        return new ResponseEntity<>(
                new EmpleadosResponse(EmpleadosService.delete(id),null ), HttpStatus.OK
        );
    }
}
