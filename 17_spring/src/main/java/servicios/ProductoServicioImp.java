package servicios;

import java.util.List;

import model.Producto;

public class ProductoServicioImp implements ProductoServicio {

	 private static final long serialVersionUID = 1L;
	 private List<Producto> productos;

	    public List<Producto> getProductos() {
	        return productos; 
	    }

	    public void incrementarPrecio(int porcentaje) {
	    	if (productos != null) {
	            for (Producto producto : productos) {
	                double nuevoPrecio = producto.getPrecio().doubleValue() * 
	                                    (100 + porcentaje)/100;
	                producto.setPrecio(nuevoPrecio);
	            }
	        }       
		}
		
	    public void setProductos(List<Producto> productos) {
	        this.productos = productos;
	    }

}
