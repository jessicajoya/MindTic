package com.MindTic.MindTic.repository;

import com.MindTic.MindTic.models.Empleados;
import com.MindTic.MindTic.models.MovimientosDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosDineroRepository extends JpaRepository<MovimientosDinero, Integer> {
}
