package com.ciclo3.udea.service;

import com.ciclo3.udea.modelos.Empresa;
import com.ciclo3.udea.repo.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepositorio empresaRepositorio;


    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }


    public Empresa getEmpresaById(Integer id){
        return empresaRepositorio.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepositorio.save(empresa);
        if (empresaRepositorio.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }


    public boolean deleteEmpresa(Integer id){
        empresaRepositorio.deleteById(id);

        if (empresaRepositorio.findById(id)!=null){
            return true;
        }
        return false;
    }


}
