package xmlFileHandler;

import enums.Files;

import java.util.HashMap;
import java.util.Map;

public class XmlFileHandlerFactory {

    public static Map<String, Files > files = new HashMap<>();

    static {
        files.put("pain", Files.PAIN);
        files.put("pain1", Files.PAIN1);
    }

    public XmlFileHandler createXmlFileHandler(String fileName) {
        return files.containsKey(fileName) ? new DefaultXmlFileHandler(fileName) : null;
    }
}
