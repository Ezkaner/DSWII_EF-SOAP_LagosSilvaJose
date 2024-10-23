package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Menu;
import pe.edu.cibertec.ws.object.Menudws;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuConvert {

    public Menu mapearAMenu(Menudws menuws) {
        Menu menu = new Menu();
        menu.setId(menuws.getId());
        menu.setNombre(menuws.getNombre());
        menu.setDescripcion(menuws.getDescripcion());
        return menu;
    }
    public Menudws mapearAMenuws(Menu menu) {
        Menudws menuws = new Menudws();
        menuws.setId(menu.getId());
        menuws.setNombre(menu.getNombre());
        menuws.setDescripcion(menu.getDescripcion());
        return menuws;
    }
    public List<Menu> mapearAMenuList(List<Menudws> menudwsList) {
        List<Menu> menuList = new ArrayList<>();
        for (Menudws menuws : menudwsList) {
            menuList.add(mapearAMenu(menuws));
        }
        return menuList;
    }
    public List<Menudws> mapearAMenudwsList(List<Menu> menuList) {
        List<Menudws> menuwsList = new ArrayList<>();
        for (Menu menu : menuList) {
            menuwsList.add(mapearAMenuws(menu));
        }
        return menuwsList;
    }

}