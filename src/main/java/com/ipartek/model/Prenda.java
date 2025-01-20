package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="prendas")
public class Prenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="prenda")
	private String prenda;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="talla")
	private String talla;
	
	@Column(name="foto")
	private String foto;
	
	
	
	
	@ManyToOne
	private Categoria categ;

	public Prenda(int id, String prenda, double precio, String talla, String foto, Categoria categ) {
		super();
		this.id = id;
		this.prenda = prenda;
		this.precio = precio;
		this.talla = talla;
		this.foto = foto;
		this.categ = categ;
	}
	
	public Prenda() {
		super();
		this.id = 0;
		this.prenda = "";
		this.precio = 0.0;
		this.talla = "";
		this.foto = "default.jpg";
		this.categ = new Categoria();
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenda() {
		return prenda;
	}

	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCateg() {
		return categ;
	}

	public void setCateg(Categoria categ) {
		this.categ = categ;
	}

	@Override
	public String toString() {
		return "Prenda [id=" + id + ", prenda=" + prenda + ", precio=" + precio + ", talla=" + talla + ", foto=" + foto
				+ ", categ=" + categ + "]";
	}
	
	public String toCSV() {
		return id + ";" + prenda + ";" + precio + ";" + talla + ";" 
				+ foto + ";" + categ.getId() ;
	}
	
	

}
