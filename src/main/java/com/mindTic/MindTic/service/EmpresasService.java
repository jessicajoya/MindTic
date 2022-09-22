package com.MindTic.MindTic.service;

import com.MindTic.MindTic.models.Empresas;
import com.MindTic.MindTic.repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresasService {
    @Autowired
    private EmpresasRepository EmpresasRepository;

    public List<Empresas> getEmpresas(){
        return EmpresasRepository.findAll();
    }

    public Empresas getEmpresas(Integer id) throws Exception {
        Optional<Empresas> EmpresasOptional = EmpresasRepository.findById(id);
        if(EmpresasOptional.isPresent()){
            return EmpresasOptional.get();
        }
        else{
            throw new Exception("Empresas no existe!!!");
        }
    }

    public Empresas saveEmpresas (Empresas EmpresasParam){
        return EmpresasRepository.save(EmpresasParam);

    }

    public Empresas putEmpresas (Empresas EmpresasParam){
        return EmpresasRepository.save(EmpresasParam);
    }
    public Empresas patchEmpresas (Empresas EmpresasParam, Integer id) throws Exception {
        try {
            Empresas EmpresasBd = getEmpresas(id);
            if(EmpresasParam.getNombre()!= null) {
                EmpresasBd.setNombre(EmpresasParam.getNombre());
            }
            if(EmpresasParam.getDireccion()!= null) {
                EmpresasBd.setDireccion(EmpresasParam.getDireccion());
            }
            if(EmpresasParam.getTelefono()!= null) {
                EmpresasBd.setTelefono(EmpresasParam.getTelefono());
            }
            if(EmpresasParam.getNit()!= null) {
                EmpresasBd.setNit(EmpresasParam.getNit());
            }
            if(EmpresasParam.getFechaCreacion()!= null) {
                EmpresasBd.setFechaCreacion(EmpresasParam.getFechaCreacion());
            }
            if(EmpresasParam.getFechaActual()!= null) {
                EmpresasBd.setFechaActual(EmpresasParam.getFechaActual());
            }
            return saveEmpresas(EmpresasBd);
        } catch (Exception e) {
            throw new Exception("Empresas no se actualizo, por que no existe");
        }
    }

    public String delete(Integer id){
        EmpresasRepository.deleteById(id);
        return "Empresas eliminado Exitosamente";
    }
}
