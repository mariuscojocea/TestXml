package extractor;

import net.thucydides.core.annotations.Shared;
import parser.Document;
import stepDefinitions.StepDefinitions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlExtractor {

    @Shared
    StepDefinitions stepDefinitions;

    public Document unmarshalFile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Unmarshal XML file
        Document document = (Document) unmarshaller.unmarshal(new File("src/main/resources/files/pain.xml"));
        return document;
    }

}
