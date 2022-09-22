package com.MindTic.MindTic.service;

import com.MindTic.MindTic.models.Rol;
import com.MindTic.MindTic.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository RolRepository;

    public List<Rol> getRol(){
        return RolRepository.findAll();
    }

    public Rol getRol(Integer id) throws Exception {
        Optional<Rol> RolOptional = RolRepository.findById(id);
        if(RolOptional.isPresent()){
            return RolOptional.get();
        }
        else{
            throw new Exception("Rol no existe!!!");
        }
    }

    public Rol saveRol (Rol RolParam){
        return RolRepository.save(RolParam);

    }

    public Rol putRol (Rol RolParam){
        return RolRepository.save(RolParam);
    }
    public Rol patchRol (Rol RolParam, Integer id) throws Exception {
        try {
            Rol RolBd = getRol(id);
            if(RolParam.getTipoRol()!= null) {
                RolBd.setTipoRol(RolParam.getTipoRol());
            }
            return saveRol(RolBd);
        } catch (Exception e) {
            throw new Exception("Rol no se actualizo, por que no existe");
        }
    }

    public String delete(Integer id){
        RolRepository.deleteById(id);
        return "Rol eliminado Exitosamente";
    }
}
