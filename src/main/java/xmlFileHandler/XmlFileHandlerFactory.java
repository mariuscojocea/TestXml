package xmlFileHandler;

public class XmlFileHandlerFactory {
    public static XmlFileHandler createXmlFileHandler(String fileName) {
        return new DefaultXmlFileHandler(fileName);
    }
}
