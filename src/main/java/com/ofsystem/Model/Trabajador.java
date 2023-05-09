package com.ofsystem.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Table (name = "trabajador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idtraba;
	public String dniTraba;
	@Column(name = "nombreTraba", nullable = false, length = 300)
	public String nombreTraba;
	@Column(name = "apellidoTraba", nullable = false, length = 300)
	public String apellidoTraba;
	@Column(name = "fechaNacTraba")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
	public java.sql.Date fechaNacTraba;
	@Column(name = "telefonoTraba",  length = 9)
	public String telefonoTraba;
	@Column(name = "direccionTraba", length = 45)
	public String direccionTraba;
	public String imagen;
	@OneToOne
	@JoinColumn(name="idUser", referencedColumnName = "idUser")
	public Usuario idUser;
	public Integer getIdTp() {
		// TODO Auto-generated method stub
		return null;
	}

	



	
}
