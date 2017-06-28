package patterns._1_creational._5_abstract_factory.live;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        final DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance(); //abstractFactory

        final DocumentBuilder factory = abstractFactory.newDocumentBuilder(); //factory

        final Document hello = factory.parse("demo_exception");
        System.out.println(hello);
    }
}
