package com.MindTic.MindTic.controller;

import com.MindTic.MindTic.models.MovimientosDinero;
import com.MindTic.MindTic.models.MovimientosDineroResponse;
import com.MindTic.MindTic.service.MovimientosDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientosDineroController {

    @Autowired
    private MovimientosDineroService MovimientosDineroService;

    @GetMapping("/MovimientosDineros")
    public ResponseEntity<List<MovimientosDinero>> getMovimientosDineros() {
        return new ResponseEntity<List<MovimientosDinero>>(
                MovimientosDineroService.getMovimientosDinero(),
                HttpStatus.OK
        );
    }

    @GetMapping("/MovimientosDinero/{id}")
    public ResponseEntity<Object> getMovimientosDineros(@PathVariable Integer id) {
        try {
            MovimientosDinero MovimientosDinero= MovimientosDineroService.getMovimientosDinero(id);
            return new ResponseEntity<>(MovimientosDinero, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/MovimientosDinero")
    public ResponseEntity<Object> getMovimientosDinero(@RequestParam Integer id) {
        try {
            MovimientosDinero MovimientosDinero = MovimientosDineroService.getMovimientosDinero(id);
            return new ResponseEntity<>(MovimientosDinero, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/MovimientosDinero")
    public ResponseEntity<MovimientosDineroResponse> postMovimientosDinero(@RequestBody MovimientosDinero MovimientosDinero) {
        return new ResponseEntity<>(new MovimientosDineroResponse("MovimientosDinero creado exitosamente",
                MovimientosDineroService.saveMovimientosDinero(MovimientosDinero)), HttpStatus.OK);
    }

    @PutMapping("/MovimientosDinero")
    public ResponseEntity<MovimientosDineroResponse> putMovimientosDinero(@RequestBody MovimientosDinero MovimientosDinero) {
        return new ResponseEntity<>(new MovimientosDineroResponse("MovimientosDinero Actualizado Exitosamente",
                MovimientosDineroService.putMovimientosDinero(MovimientosDinero)), HttpStatus.OK);
    }

    @PatchMapping("/MovimientosDinero/{id}")
    public ResponseEntity<MovimientosDineroResponse> patch(@RequestBody MovimientosDinero MovimientosDinero, @PathVariable Integer id){
        try {
            return new ResponseEntity<>(
                    new MovimientosDineroResponse("Actualizacion Exitosa!!",
                            MovimientosDineroService.patchMovimientosDinero(MovimientosDinero,id)),
                            HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MovimientosDineroResponse(e.getMessage(),null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("/MovimientosDinero/{id}")
    public ResponseEntity<MovimientosDineroResponse> delete(@PathVariable Integer id){
        return new ResponseEntity<>(
                new MovimientosDineroResponse(MovimientosDineroService.delete(id),null ), HttpStatus.OK
        );
    }
}
