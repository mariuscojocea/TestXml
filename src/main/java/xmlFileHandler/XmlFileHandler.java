package xmlFileHandler;

import xmlParser.Document;

import javax.xml.bind.JAXBException;

public interface XmlFileHandler {
    Document loadXmlFile(String filePath) throws JAXBException;
}
