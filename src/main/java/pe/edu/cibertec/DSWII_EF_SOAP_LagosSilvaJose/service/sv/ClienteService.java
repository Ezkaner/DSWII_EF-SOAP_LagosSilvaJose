package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.sv;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Cliente;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.repository.ClienteRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IClienteService;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.convert.ClienteConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteConvert clienteConvert;

    @Override
    public PostClienteResponse registrarCliente(PostClienteRequest request) {
        PostClienteResponse postClienteResponse = new PostClienteResponse();
        Cliente nuevoCliente = clienteRepository.save(
                clienteConvert.mapearACliente(request.getCliente())
        );
        postClienteResponse.setCliente(
                clienteConvert.mapearAClientews(nuevoCliente)
        );
        return postClienteResponse;
    }

    @Override
    public PutClienteResponse actualizarCliente(PutClienteRequest request) {
        PutClienteResponse putClienteResponse = new PutClienteResponse();
        Cliente cliente = clienteRepository.findById(request.getCliente().getId()).orElse(null);
        putClienteResponse.setCliente(clienteConvert.mapearAClientews(clienteRepository.save(
                clienteConvert.mapearACliente(request.getCliente())
                    ))
            );
        return putClienteResponse;
    }

    @Override
    public GetClientesResponse buscarClientes() {
        GetClientesResponse getClientesResponse = new GetClientesResponse();
        getClientesResponse.getCliente().addAll(
                clienteConvert.mapearAClientewsList(clienteRepository.findAll())
        );
        return getClientesResponse;
    }

    @Override
    public GetClienteResponse buscarClienteXId(Integer id) {
        GetClienteResponse getClienteResponse = new GetClienteResponse();
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        getClienteResponse.setCliente(
                clienteConvert.mapearAClientews(cliente)
            );

        return getClienteResponse;
    }

}