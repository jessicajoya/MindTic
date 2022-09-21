package com.MindTic.MindTic.service;

import com.MindTic.MindTic.models.Empleados;
import com.MindTic.MindTic.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {
    @Autowired
    private EmpleadosRepository EmpleadosRepository;

    public List<Empleados> getEmpleados(){
        return EmpleadosRepository.findAll();
    }

    public Empleados getEmpleados(Integer id) throws Exception {
        Optional<Empleados> EmpleadosOptional = EmpleadosRepository.findById(id);
        if(EmpleadosOptional.isPresent()){
            return EmpleadosOptional.get();
        }
        else{
            throw new Exception("Empleados no existe!!!");
        }
    }

    public Empleados saveEmpleados (Empleados EmpleadosParam){
        return EmpleadosRepository.save(EmpleadosParam);

    }

    public Empleados putEmpleados (Empleados EmpleadosParam){
        return EmpleadosRepository.save(EmpleadosParam);
    }
    public Empleados patchEmpleados (Empleados EmpleadosParam, Integer id) throws Exception {
        try {
            Empleados EmpleadosBd = getEmpleados(id);
            if(EmpleadosParam.getNombreCompleto()!= null) {
                EmpleadosBd.setNombreCompleto(EmpleadosParam.getNombreCompleto());
            }
            if(EmpleadosParam.getEmail()!= null) {
                EmpleadosBd.setEmail(EmpleadosParam.getEmail());
            }
            if(EmpleadosParam.getRol()!= null) {
                EmpleadosBd.setRol(EmpleadosParam.getRol());
            }
            if(EmpleadosParam.getEmpresas()!= null) {
                EmpleadosBd.setEmpresas(EmpleadosParam.getEmpresas());
            }
            if(EmpleadosParam.getFechaCreacion()!= null) {
                EmpleadosBd.setFechaCreacion(EmpleadosParam.getFechaCreacion());
            }
            if(EmpleadosParam.getFechaActual()!= null) {
                EmpleadosBd.setFechaActual(EmpleadosParam.getFechaActual());
            }
            return saveEmpleados(EmpleadosBd);
        } catch (Exception e) {
            throw new Exception("Empleados no se actualizo, por que no existe");
        }
    }

    public String delete(Integer id){
        EmpleadosRepository.deleteById(id);
        return "Empleados eliminado Exitosamente";
    }
}
