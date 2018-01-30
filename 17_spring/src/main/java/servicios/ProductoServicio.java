package servicios;

import java.io.Serializable;
import java.util.List;

import model.Producto;

public interface ProductoServicio extends Serializable {

    public void incrementarPrecio(int porcentaje);
    
    public List<Producto> getProductos();

}