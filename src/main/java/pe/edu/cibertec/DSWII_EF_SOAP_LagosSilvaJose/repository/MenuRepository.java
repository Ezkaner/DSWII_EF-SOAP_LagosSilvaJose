package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
}