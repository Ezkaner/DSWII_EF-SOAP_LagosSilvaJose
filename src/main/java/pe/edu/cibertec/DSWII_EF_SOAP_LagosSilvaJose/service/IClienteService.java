package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service;

import pe.edu.cibertec.ws.object.*;

public interface IClienteService {
    PostClienteResponse registrarCliente(PostClienteRequest request);
    PutClienteResponse actualizarCliente(PutClienteRequest request);
    GetClientesResponse buscarClientes();
    GetClienteResponse buscarClienteXId(Integer id);
}