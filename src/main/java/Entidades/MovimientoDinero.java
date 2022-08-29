package Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "MoviminetosDinero")
public class MovimientoDinero {

    @Setter @Getter @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="movimientoId")
    private String movimientoId;

    @Setter @Getter @Column(name="monto")
    private float monto;

    @Setter @Getter @Column(name="tipoMovimiento")
    private boolean tipoMovimiento;

    @Setter @Getter @Column(name="conceptoMovimiento")
    private String conceptoMovimineto;

    @ManyToOne() @Setter @Getter
    @JoinColumn(name = "idEmpleados")
    private Empleado empleado;
}
