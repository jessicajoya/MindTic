package com.MindTic.MindTic.service;

import com.MindTic.MindTic.models.MovimientosDinero;
import com.MindTic.MindTic.repository.MovimientosDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosDineroService {
    @Autowired
    private MovimientosDineroRepository MovimientosDineroRepository;

    public List<MovimientosDinero> getMovimientosDinero(){
        return MovimientosDineroRepository.findAll();
    }

    public MovimientosDinero getMovimientosDinero(Integer id) throws Exception {
        Optional<MovimientosDinero> MovimientosDineroOptional = MovimientosDineroRepository.findById(id);
        if(MovimientosDineroOptional.isPresent()){
            return MovimientosDineroOptional.get();
        }
        else{
            throw new Exception("MovimientosDinero no existe!!!");
        }
    }

    public MovimientosDinero saveMovimientosDinero (MovimientosDinero MovimientosDineroParam){
        return MovimientosDineroRepository.save(MovimientosDineroParam);

    }

    public MovimientosDinero putMovimientosDinero (MovimientosDinero MovimientosDineroParam){
        return MovimientosDineroRepository.save(MovimientosDineroParam);
    }
    public MovimientosDinero patchMovimientosDinero (MovimientosDinero MovimientosDineroParam, Integer id) throws Exception {
        try {
            MovimientosDinero MovimientosDineroBd = getMovimientosDinero(id);
            if(MovimientosDineroParam.getConceptoMovimiento()!= null) {
                MovimientosDineroBd.setConceptoMovimiento(MovimientosDineroParam.getConceptoMovimiento());
            }
            if(MovimientosDineroParam.getEmpleados()!= null) {
                MovimientosDineroBd.setEmpleados(MovimientosDineroParam.getEmpleados());
            }
            if(MovimientosDineroParam.getFechaCreacion()!= null) {
                MovimientosDineroBd.setFechaCreacion(MovimientosDineroParam.getFechaCreacion());
            }
            if(MovimientosDineroParam.getFechaActual()!= null) {
                MovimientosDineroBd.setFechaActual(MovimientosDineroParam.getFechaActual());
            }
            return saveMovimientosDinero(MovimientosDineroBd);
        } catch (Exception e) {
            throw new Exception("MovimientosDinero no se actualizo, por que no existe");
        }
    }

    public String delete(Integer id){
        MovimientosDineroRepository.deleteById(id);
        return "MovimientosDinero eliminado Exitosamente";
    }
}
