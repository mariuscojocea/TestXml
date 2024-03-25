package xmlValidation;

import net.serenitybdd.core.Serenity;
import utils.JsonUtils;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

import static junit.framework.TestCase.fail;

public class XmlValidation {


    public void checkXml(String xmlFile, String xsdFile) throws Exception{
        String xmlFilePath = new JsonUtils().getXmlFilePath(xmlFile);
        String xsdFilePath = new JsonUtils().getXsdFilePath(xmlFile);

        try {

            // create a SchemaFactory and specify the XML schema (XSD)
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));

            // create a validator for the XML schema
            Validator validator = schema.newValidator();

            XmlValidationErrorHandler errorHandler = new XmlValidationErrorHandler();
            validator.setErrorHandler(errorHandler);

            // validate the XML document against the schema
            validator.validate(new StreamSource(xmlFilePath));

            // if there are any errors, print them
            if (!errorHandler.getErrorMessages().isEmpty()) {
                errorHandler.getErrorMessages().forEach(System.out::println);
                Serenity.recordReportData().withTitle("XML Validation Errors").andContents(errorHandler.getErrorMessages().toString());
                fail("Error validating XML file: " + xmlFile + " against schema: " + xsdFile);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
