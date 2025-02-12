package com.example.A_8TrabajoFinalAD;

public class ProductoNoEncontradoException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNoEncontradoException(int id) {
        super("Producto con ID " + id + " no encontrado");
    }
}

