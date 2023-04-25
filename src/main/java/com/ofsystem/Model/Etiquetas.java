package com.ofsystem.Model;

import com.ofsystem.Enums.EtiquetaName;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "etiquetas")
@Data
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtiqueta;
    @Enumerated(EnumType.STRING)
    @Column(name = "nombreEtiqueta", nullable = false)
    private EtiquetaName nombreEtiqueta;

    public Etiquetas() {
    }

    public Etiquetas(EtiquetaName nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }
}


