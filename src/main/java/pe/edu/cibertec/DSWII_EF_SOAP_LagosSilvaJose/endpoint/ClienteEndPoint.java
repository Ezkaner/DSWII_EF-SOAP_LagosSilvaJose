package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IClienteService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class ClienteEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IClienteService clienteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientesRequest")
    @ResponsePayload
    public GetClientesResponse getClientes(@RequestPayload GetClientesRequest request){
        return clienteService.buscarClientes();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClienteRequest")
    @ResponsePayload
    public GetClienteResponse getCliente(@RequestPayload GetClienteRequest request){
        return clienteService.buscarClienteXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putClienteRequest")
    @ResponsePayload
    public PutClienteResponse actualizarCliente(@RequestPayload PutClienteRequest request){
        return clienteService.actualizarCliente(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postClienteRequest")
    @ResponsePayload
    public PostClienteResponse saveCliente(@RequestPayload PostClienteRequest request){
        return clienteService.registrarCliente(request);
    }


}