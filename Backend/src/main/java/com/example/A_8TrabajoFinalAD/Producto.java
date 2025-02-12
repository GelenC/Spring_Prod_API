package com.example.A_8TrabajoFinalAD;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/*Paso 2: Validaciones del nombre y precio
Validar el nombre:

No debe estar vacío ni contener solo espacios.
No debe contener números.
Validar el precio:

No debe contener caracteres alfanuméricos.
Debe ser un valor de tipo double mayor que 0.0.

se activa el error 400 bad request
*/


@Entity
@Table(name = "producto")
public class Producto {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @NotBlank(message = "El nombre no puede estar vacío ni contener solo espacios")
	 @Pattern(regexp = "^[^0-9]*$", message = "El nombre no debe contener números")
	 private String nombre;
	 
	 @NotNull(message = "El precio no puede ser nulo")
	 @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0.0")
	 private double precio;
	 
	 @Column(name = "fecha_creacion")
	 private LocalDateTime fechaCreacion = LocalDateTime.now();
	 
	 public Producto() {
	 }
	public Producto(int id, String nombre, double precio, LocalDateTime fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
	}
	
//Getter y Setter...	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	 
	 
}
