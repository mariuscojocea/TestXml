package xmlFileHandler;

import utils.JsonUtils;
import xmlParser.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class DefaultXmlFileHandler implements XmlFileHandler{

    private final String fileName;

    public DefaultXmlFileHandler(String fileName) {
        this.fileName = fileName;
    }

    public Document loadXmlFile(String fileName) throws FileNotFoundException {
        String filePath = new JsonUtils().getXmlFilePath(fileName);
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
