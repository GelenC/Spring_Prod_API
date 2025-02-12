package com.example.A_8TrabajoFinalAD;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	 
	    private final ProductoService productoServise;
	    
	    public ProductoController(ProductoService productoService) {
	        this.productoServise = productoService;
	    }
//Listas productos	    
	 @GetMapping
	    public List<Producto> listarProductos() {
	        return productoServise.obtenerTodosLosProductos();
	    }
//Obtener producto	 	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Producto> obtenerProducto(@PathVariable int id) {
	     Producto producto = productoServise.obtenerProductoPorId(id);
	     return ResponseEntity.ok(producto);
	 }	 
//Agregar producto	  
	  @PostMapping
	    public ResponseEntity<?> agregarProducto(@Valid @RequestBody Producto producto, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            StringBuilder mensajeError = new StringBuilder("Errores de validación: ");
	            for (ObjectError error : bindingResult.getAllErrors()) {
	                mensajeError.append(error.getDefaultMessage()).append(", ");
	            }
	            return ResponseEntity.badRequest().body(mensajeError.toString());
	        }
	        Producto productoGuardado = productoServise.guardarProducto(producto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
	   }
	    
//Borrar producto	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
	      if (productoServise.eliminarProductoPorId(id)) {
	          return ResponseEntity.ok("Producto eliminado correctamente");
	      } else {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
	      }
	  }

//Actualizra información de producto	  
	  @PutMapping("/{id}")
	  public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
	      Producto productoActualizado = productoServise.actualizarProducto(id, producto);
	      if (productoActualizado != null) {
	          return ResponseEntity.ok(productoActualizado);
	      } else {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	      }
	  }
}
