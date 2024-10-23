package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service;

import pe.edu.cibertec.ws.object.*;

public interface IProductoService {
    PostProductoResponse registrarProducto(PostProductoRequest request);
    PutProductoResponse actualizarProducto(PutProductoRequest request);
    GetProductosResponse buscarProductos();
    GetProductoResponse buscarProductoXId(Integer id);
}