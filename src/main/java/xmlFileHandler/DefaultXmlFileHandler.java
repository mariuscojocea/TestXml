package xmlFileHandler;

import parser.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DefaultXmlFileHandler implements XmlFileHandler{

    private final String fileName;

    public DefaultXmlFileHandler(String fileName) {
        this.fileName = fileName;
    }

    public Document loadXmlFile(String fileName) {
        String filePath = "src/main/resources/xmlFiles/" + fileName + ".xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Document.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xmlFile = new File(filePath);
            return (Document) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
