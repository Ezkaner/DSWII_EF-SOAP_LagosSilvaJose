package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service;

import pe.edu.cibertec.ws.object.*;

public interface IMenuService {
    PostMenuResponse registrarMenu(PostMenuRequest request);
    PutMenuResponse actualizarMenu(PutMenuRequest request);
    GetMenusResponse buscarMenus();
    GetMenuResponse buscarMenuXId(Integer id);
}