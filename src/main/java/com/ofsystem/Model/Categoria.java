package com.ofsystem.Model;


import com.ofsystem.Enums.CategoriaName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria_product")
@Data
public class Categoria {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idCateg;
    @Enumerated(EnumType.STRING)
    @Column(name = "nombreCateg", nullable = false, length = 1000)
    public CategoriaName nombreCateg;

    public Categoria() {

    }

    public Categoria(CategoriaName nombreCateg) {
        this.nombreCateg = nombreCateg;
    }
}
