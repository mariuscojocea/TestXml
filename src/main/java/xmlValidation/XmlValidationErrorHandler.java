package xmlValidation;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;


public class XmlValidationErrorHandler implements ErrorHandler {

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public void warning(SAXParseException exception) {
        errorMessages.add("Warning: " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        errorMessages.add("Error: " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) {
        errorMessages.add("Fatal Error: " + exception.getMessage());
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
