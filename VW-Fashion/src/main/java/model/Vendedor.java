package model;

import java.awt.geom.Line2D.Float;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Vendedor")
public class Vendedor extends User {
	private Float adicional;

	public Float getAdicional() {
		return adicional;
	}

	public void setAdicional(Float adicional) {
		this.adicional = adicional;
	}
	
	public Vendedor() {
		
	}
}
