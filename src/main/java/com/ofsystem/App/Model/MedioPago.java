package com.ofsystem.App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mediopago")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedioPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedioPago;
    private String nombre;
    private String descripcion;
}
