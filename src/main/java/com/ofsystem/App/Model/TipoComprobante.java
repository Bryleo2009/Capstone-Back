package com.ofsystem.App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tipo_comprobante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoComp;
    private String nombre;
    private String descripcion;
}
