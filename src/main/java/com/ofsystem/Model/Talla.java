package com.ofsystem.Model;

import com.ofsystem.Enums.TallaName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "talla")
@Data
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTalla;
    @Enumerated(EnumType.STRING)
    @Column(name = "nombreTalla", nullable = false)
    private TallaName nombreTalla;

    public Talla(TallaName nombreTalla) {
        this.nombreTalla = nombreTalla;
    }

    public Talla() {
    }
}


