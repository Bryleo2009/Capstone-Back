package com.ofsystem.Model;



import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

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
