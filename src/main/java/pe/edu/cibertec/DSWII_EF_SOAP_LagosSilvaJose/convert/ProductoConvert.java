package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Producto;
import pe.edu.cibertec.ws.object.Productows;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoConvert {

    public Producto mapearAProducto(Productows productows){
        Producto producto = new Producto();
        producto.setId(productows.getId());
        producto.setNombre(productows.getNombre());
        producto.setDescripcion(productows.getDescripcion());
        return producto;
    }
    public Productows mapearAProductows(Producto producto){
        Productows productows = new Productows();
        productows.setId(producto.getId());
        productows.setNombre(producto.getNombre());
        productows.setDescripcion(producto.getDescripcion());
        return productows;
    }
    public List<Producto> mapearAProductoList(List<Productows> productowsList){
        List<Producto> productoList = new ArrayList<>();
        for(Productows productows : productowsList){
            productoList.add(mapearAProducto(productows));
        }
        return productoList;
    }
    public List<Productows> mapearAProductowsList(List<Producto> productoList){
        List<Productows> productowsList = new ArrayList<>();
        for(Producto producto : productoList){
            productowsList.add(mapearAProductows(producto));
        }
        return productowsList;
    }

}