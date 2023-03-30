package com.ofsystem.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "tipo_compro")
@Data
public class TipoCompro {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTc;
    @Column(name = "nombreTc", nullable = false, length = 20)
    @Size(min = 3, message = "Minimo 3 caracteres")
    public String nombreTc;

	
}
