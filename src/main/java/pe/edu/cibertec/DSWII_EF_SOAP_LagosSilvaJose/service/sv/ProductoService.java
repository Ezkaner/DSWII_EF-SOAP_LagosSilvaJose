package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.sv;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Producto;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.repository.ProductoRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IProductoService;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.convert.ProductoConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoConvert productoConvert;

    @Override
    public PostProductoResponse registrarProducto(PostProductoRequest request) {
        PostProductoResponse postProductoResponse = new PostProductoResponse();
        Producto nuevaProducto = ProductoRepository.save(
                productoConvert.mapearAProducto(request.getProducto())
        );
        postProductoResponse.setProducto(
                productoConvert.mapearAProductows(nuevaProducto)
        );
        return postProductoResponse;
    }

    @Override
    public PutProductoResponse actualizarProducto(PutProductoRequest request) {
        PutProductoResponse putProductoResponse = new PutProductoResponse();
        Producto producto = productoRepository.findById(request.getProducto().getId()).orElse(null);
        putProductoResponse.setProducto(
                    productoConvert.mapearAProductows(productoRepository.save(
                            productoConvert.mapearAProducto(request.getProducto())
                    ))
            );
        return putProductoResponse;
    }

    @Override
    public GetProductosResponse buscarProductos() {
        GetProductosResponse getProductosResponse = new GetProductosResponse();
        getProductosResponse.getProducto().addAll(
                productoConvert.mapearAProductowsList(productoRepository.findAll())
        );
        return getProductosResponse;
    }

    @Override
    public GetProductoResponse buscarProductoXId(Integer id) {
        GetProductoResponse getProductoResponse = new GetProductoResponse();
        Producto producto = productoRepository.findById(id).orElse(null);

            getProductoResponse.setProducto(
                   productoConvert.mapearAProductows(producto)
            );
        return getProductoResponse;
    }
}