package Task6;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Dom {

    public static void DomParser(String filename)  throws Exception {
        try {
            Document doc;
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(new File(filename));
            Node rootNode = doc.getDocumentElement();
            mainLoop:
            for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
                Node countriesNode = rootNode.getChildNodes().item(i);
                if (countriesNode.getNodeName().equals("ListData")) {
                    for (int j = 0; j < countriesNode.getChildNodes().getLength(); j++) {
                        Node countryNode = countriesNode.getChildNodes().item(j);
                        if (countryNode.getNodeName().equals("StudentData")) {
                            // Знаходимо атрибут за іменем:
                            if (countryNode.getAttributes().getNamedItem("Name").getNodeValue().equals("Арсен")) {
                                for (int k = 0; k < countryNode.getChildNodes().getLength(); k++) {
                                    Node capitalNode = countryNode.getChildNodes().item(k);
                                    if (capitalNode.getNodeName().equals("assessment")) {
                                        capitalNode.getAttributes().getNamedItem("As").setNodeValue("Тут был Dom6");
                                        break mainLoop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc),
                    new StreamResult(new FileOutputStream(new File("HelloDom.xml"))));
        }
        catch (Exception  e) {
            e.printStackTrace();
        }
    }
}

