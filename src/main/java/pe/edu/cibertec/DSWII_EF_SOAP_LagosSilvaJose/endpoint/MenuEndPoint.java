package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IMenuService;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IClienteService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class MenuEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IMenuService menuService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMenusRequest")
    @ResponsePayload
    public GetMenusResponse getMenus(@RequestPayload GetMenusRequest request){
        return menuService.buscarMenus();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMenuRequest")
    @ResponsePayload
    public GetMenuResponse getMenu(@RequestPayload GetMenuRequest request){
        return menuService.buscarMenuXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putMenuRequest")
    @ResponsePayload
    public PutMenuResponse actualizarMenu(@RequestPayload PutMenuRequest request){
        return menuService.actualizarMenu(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMenuRequest")
    @ResponsePayload
    public PostMenuResponse saveMenu(@RequestPayload PostMenuRequest request){
        return menuService.registrarMenu(request);
    }
}