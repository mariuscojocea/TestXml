package xmlValidation;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XmlValidation {

        public static boolean checkXml(String xmlFile, String xsdFile) {
        try {

            // Create a SchemaFactory and specify the XML schema language and source
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/xsd/" + xsdFile + ".xsd"));

            // Create a validator for the XML schema
            Validator validator = schema.newValidator();

            // Validate the XML document against the schema
            validator.validate(new StreamSource("src/main/resources/xmlFiles/" + xmlFile + ".xml"));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
