package com.ofsystem.Capstone.Model.Usuario;



import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador extends Cliente{
	public String imagen;
	@OneToOne
	@JoinColumn(name="idUserTrabajador", referencedColumnName = "idUser")
	public Usuario idUserTrabajador;
	public boolean isTrabajador;
}
