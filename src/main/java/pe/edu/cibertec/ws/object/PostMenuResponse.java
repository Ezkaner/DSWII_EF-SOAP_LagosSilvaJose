//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.23 a las 03:57:11 AM GMT-05:00 
//


package pe.edu.cibertec.ws.object;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="menu" type="{http://www.cibertec.edu.pe/ws/object}menudws"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "menu"
})
@XmlRootElement(name = "postMenuResponse")
public class PostMenuResponse {

    @XmlElement(required = true)
    protected Menudws menu;

    /**
     * Obtiene el valor de la propiedad menu.
     * 
     * @return
     *     possible object is
     *     {@link Menudws }
     *     
     */
    public Menudws getMenu() {
        return menu;
    }

    /**
     * Define el valor de la propiedad menu.
     * 
     * @param value
     *     allowed object is
     *     {@link Menudws }
     *     
     */
    public void setMenu(Menudws value) {
        this.menu = value;
    }

}
