package pe.edu.cibertec.DSWII_EF_SOAP_LagosSilvaJose.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class ClienteWsdlConfig {

    @Bean(name = "clientes")
    public DefaultWsdl11Definition domicilioWsdl11Definition(XsdSchema clientesEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ClientesPort");
        wsdl11Definition.setLocationUri("/ws/cliente");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(clientesEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema clientesEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/cliente.xsd"));
    }
}
