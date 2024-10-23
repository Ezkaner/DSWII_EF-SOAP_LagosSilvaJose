package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IProductoService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class ProductoEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IProductoService productoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosRequest")
    @ResponsePayload
    public GetProductosResponse getProductos(@RequestPayload GetProductosRequest request){
        return productoService.buscarProductos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse getProducto(@RequestPayload GetProductoRequest request){
        return productoService.buscarProductoXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putProductoRequest")
    @ResponsePayload
    public PutProductoResponse actualizarProducto(@RequestPayload PutProductoRequest request){
        return productoService.actualizarProducto(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductoRequest")
    @ResponsePayload
    public PostProductoResponse saveProducto(@RequestPayload PostProductoRequest request){
        return productoService.registrarProducto(request);
    }
}