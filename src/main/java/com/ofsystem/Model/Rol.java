package com.ofsystem.Model;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@ApiModel(description = "")
@Entity
@Table(name = "Rol")
@Data

public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "idRol* Autogenerado")
	private int idRol;
	
	@Column(nullable = false, length = 1000)
	@ApiModelProperty(notes = "descRol* requiere min 3 caracteres")
	@Size(min = 3, message = "descRol* requiere min 3 caracteres")
	private String descRol;
}
