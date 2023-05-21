package com.ofsystem.Model;


import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.EtiquetaName;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "categoria_product")
@Data
@AllArgsConstructor
public class Categoria {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idCateg;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private CategoriaName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public Categoria() {

    }

    public Categoria(CategoriaName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }
}
