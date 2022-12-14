package com.mindTic.MindTic.dao;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;
import com.mindTic.MindTic.Entidades.Rol;

import java.util.List;

public interface UsuarioDao {

    List<Empresa> listarEmpresa();

    List<Empleado> listarEmpleado();

    List<MovimientoDinero> listarMovimiento();

    List<Rol> listarRol();

    void eliminarEmpleados(Long id);

    void eliminarEmpresas(Long id);

    void eliminarMovimientos(Long id);

    Empleado verificarLogin(Empleado empleado);

    void nempresa(Empresa empresa);

    void nempleado(Empleado empleadoa);

    void nuevoMovimientos(MovimientoDinero movimientoDinero);

    void aempresa(Empresa empresa);

    Empleado aempleado(long id, Empleado empleado);

    void aMovimientos(long id, MovimientoDinero movimientoDinero);

    List<String> traerEmpleados(Long idempleado);
    Empresa traerEmpresas(Long id);

    List<String> traerMovimientos(Long id);


}
