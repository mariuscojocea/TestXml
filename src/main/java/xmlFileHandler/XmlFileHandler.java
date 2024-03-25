package xmlFileHandler;

import xmlParser.Document;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlFileHandler {
    Document loadXmlFile(String filePath) throws JAXBException, FileNotFoundException;
}
