package com.example.A_8TrabajoFinalAD;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	  @Autowired
	    private ProductoRepository productoRepository;
//Guardar producto	  
	   public Producto guardarProducto(Producto producto) {
	        return productoRepository.save(producto);
	    }
//Listar productos	   
	    public List<Producto> obtenerTodosLosProductos() {
	        return productoRepository.findAll();
	    }
//Obtener producto
	    public Producto obtenerProductoPorId(int id) {
	        return productoRepository.findById(id)
	            .orElseThrow(() -> new ProductoNoEncontradoException(id));
	    }
//Eliminar producto
	    public boolean eliminarProductoPorId(int id) {
	        if (productoRepository.existsById(id)) {
	            productoRepository.deleteById(id);
	            return true;
	        }
	        return false; 
	    }	    
//Actualizar información de producto	    
	    public Producto actualizarProducto(int id, Producto productoActualizado) {
	        return productoRepository.findById(id).map(producto -> {
	            producto.setNombre(productoActualizado.getNombre());
	            producto.setPrecio(productoActualizado.getPrecio());
	            producto.setFechaCreacion(productoActualizado.getFechaCreacion()); 
	            return productoRepository.save(producto);
	        }).orElse(null); 
	    }
}
