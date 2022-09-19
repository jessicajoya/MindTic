package com.ciclo3.udea.repo;

import com.ciclo3.udea.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//decirle a spring que la clase es un repo


public interface EmpresaRepositorio extends JpaRepository <Empresa, Integer> {
}

//Relacion <Empresa, Integer>