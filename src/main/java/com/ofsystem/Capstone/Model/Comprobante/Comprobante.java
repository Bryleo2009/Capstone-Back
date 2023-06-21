package com.ofsystem.Capstone.Model.Comprobante;

import java.util.Date;

import javax.persistence.*;

import com.ofsystem.Capstone.Model.Enums.TipoCompro;
import com.ofsystem.Capstone.Model.Enums.TipoPago;
import com.ofsystem.Capstone.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name = "comprobante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comprobante {
	@Id
	@Column(length = 50)
	public String idComp;
	@Column(name = "iuc", nullable = false)
	public String iuc;
	@Column(name = "montoSubtotalComp", nullable = false)
	public double montoSubtotalComp; //suma de los totales de items sin igv
	@Column(name = "montoTotalComp", nullable = false)
	public double montoTotalComp; //incluido igv
	@Column(name = "fechaEmiComp", nullable = false)
	public Date fechaEmiComp; //21/01/2021
	@Column(name = "direccionComp", nullable = false)
	public String direccionComp;
	@Column(name = "ubigeoComp", nullable = false)
	public String ubigeoComp;
	@Column(name = "rucComp", nullable = true)
	public String ruc;
	@Column(name = "razonSocialComp", nullable = true)
	public String razonSocial;
	@ManyToOne
    @JoinColumn(name="idTp", referencedColumnName = "idTp")
	public TipoPago idTp;
	@ManyToOne
    @JoinColumn(name="idTc", referencedColumnName = "idTc")
	public TipoCompro idTc;
	@ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "id")
	public Cliente idCliente;

//	private static int ultimoNumeroComprobante = 0;
//
//	@PrePersist
//	public void generarNumeroComprobante() {
//		// Incrementar el número de comprobante correlativo
//		ultimoNumeroComprobante++;
//
//		// Obtener la fecha actual
//		LocalDate fecha = LocalDate.now();
//
//		// Formatear la fecha en formato 'yyyyMMdd'
//		String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//
//		// Generar el número de comprobante correlativo
//		idComp = fechaFormateada + String.format("%04d", ultimoNumeroComprobante);
//	}


	public void setIuc() {
		this.iuc = generarIUC(montoSubtotalComp,montoTotalComp,fechaEmiComp,ubigeoComp,idTp,idTc,idCliente);
	}

	public String generarIUC (double montoSubtotalComp, double montoTotalComp, Date fechaEmiComp, String ubigeoComp, TipoPago idTp, TipoCompro idTc, Cliente idCliente){
		String iuc = "";
		iuc = "MS" + montoSubtotalComp + "MT" + montoTotalComp + "U" + ubigeoComp + "TP" + idTp.getIdTp() + "TC" + idTc.getIdTc() +
				"C" + idCliente.getNumDocumento() + "-" + fechaEmiComp.getDate() + fechaEmiComp.getMonth() + fechaEmiComp.getYear() + fechaEmiComp.getHours() + fechaEmiComp.getMinutes();
		return iuc;
	}
}
