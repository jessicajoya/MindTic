package Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "Empleados")
public class Empleado {

    @Setter @Getter @Id @GeneratedValue (strategy = GenerationType.AUTO) @Column(name="empleadoId")
    private Long empleadoId;

    @Setter @Getter @Column(name="nombreCompleto")
    private String nombreCompleto;

    @Setter @Getter @Column(name="email")
    private String email;

    @Getter    @Setter @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Setter @Getter @Column(name="idRol")
    private String idRol;

    @Getter    @Setter @Column(name="fecha_act")
    private Date fecha_act;

    @ManyToOne()
    @JoinColumn(name = "idEmpresa") @Setter @Getter
    private Empresa empresa;

    @OneToMany(mappedBy = "Empleados", cascade = CascadeType.ALL, orphanRemoval = true) @Setter @Getter
    private List<MovimientoDinero> moviminetosList;

}
