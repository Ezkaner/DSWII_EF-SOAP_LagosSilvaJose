package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.sv;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Menu;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Cliente;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.repository.MenuRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.service.IMenuService;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.convert.MenuConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class MenuService implements IMenuService {
    private final MenuRepository menuRepository;
    private final MenuConvert menuConvert;

    @Override
    public PostMenuResponse registrarMenu(PostMenuRequest request) {
        PostMenuResponse postMenuResponse = new PostMenuResponse();
        Menu nuevoMenu = menuRepository.save(
                menuConvert.mapearAMenu(request.getMenu())
        );
        postMenuResponse.setMenu(
                menuConvert.mapearAMenuws(nuevoMenu)
        );
        return postMenuResponse;
    }

    @Override
    public PutMenuResponse actualizarMenu(PutMenuRequest request) {
        PutMenuResponse putMenuResponse = new PutMenuResponse();
        Menu menu = menuRepository.findById(request.getMenu().getId()).orElse(null);
        putMenuResponse.setMenu(
                    menuConvert.mapearAMenuws(menuRepository.save(
                            menuConvert.mapearAMenu(request.getMenu())
                    ))
            );

        return putMenuResponse;
    }

    @Override
    public GetMenusResponse buscarMenus() {
        GetMenusResponse getMenusResponse = new GetMenusResponse();
        getMenusResponse.getMenus().addAll(
                menuConvert.mapearAMenudwsList(menuRepository.findAll())
        );
        return getMenusResponse;
    }

    @Override
    public GetMenuResponse buscarMenuXId(Integer id) {
        GetMenuResponse getMenuResponse = new GetMenuResponse();
        Menu medicamento = menuRepository.findById(id).orElse(null);
            getMenuResponse.setMenu(
                    menuConvert.mapearAMenuws(medicamento)
            );

        return getMenuResponse;
    }
}