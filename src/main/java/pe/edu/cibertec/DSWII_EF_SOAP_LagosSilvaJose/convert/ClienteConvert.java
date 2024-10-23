package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Cliente;
import pe.edu.cibertec.ws.object.Clientews;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConvert {

    public Cliente mapearACliente(Clientews clientews){
        Cliente cliente = new Cliente();
        cliente.setId(clientews.getId());
        cliente.setNombre(clientews.getNombre());
        return cliente;
    }
    public Clientews mapearAClientews(Cliente cliente){
        Clientews clientews = new Clientews();
        clientews.setId(cliente.getId());
        clientews.setNombre(cliente.getNombre());
        return clientews;
    }
    public List<Cliente> mapearAClienteList(List<Clientews> clientewsList){
        List<Cliente> clienteList = new ArrayList<>();
        for(Clientews clientews : clientewsList){
            clienteList.add(mapearACliente(clientews));
        }
        return clienteList;
    }
    public List<Clientews> mapearAClientewsList(List<Cliente> clienteList){
        List<Clientews> clientewsList = new ArrayList<>();
        for(Cliente cliente : clienteList){
            clientewsList.add(mapearAClientews(cliente));
        }
        return clientewsList;
    }

}