package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class ProductoWsdlConfig {

    @Bean(name = "productos")
    public DefaultWsdl11Definition domicilioWsdl11Definition(XsdSchema productoEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductosPort");
        wsdl11Definition.setLocationUri("/ws/producto");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(productoEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema productoEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/producto.xsd"));
    }
}