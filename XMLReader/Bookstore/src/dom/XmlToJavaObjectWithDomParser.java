package dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import error.handler.ErrorsHandler;

public class XmlToJavaObjectWithDomParser {
	public void convertToJavaObject() throws ParserConfigurationException, SAXException, IOException {
		ErrorsHandler errHandler = new ErrorsHandler();
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		domFactory.setValidating(true);

		DocumentBuilder builder = domFactory.newDocumentBuilder();

		/*
		 * In order for validation to work properly, a class implementing ErrorHandler
		 * interface should be created and its methods are to be implemented.
		 * 
		 */
		builder.setErrorHandler(errHandler);

		Document doc = builder.parse("src/schema/bookstore.xml");

		doc.getDocumentElement().normalize();

		NodeList subList = doc.getElementsByTagName("book");
		Node node = subList.item(0);
		NodeList children = node.getChildNodes();


		Node[] nodes = new Node[children.getLength() / 2];
		int j = 0;
		for (int i = 0; i < children.getLength(); ++i) {
			if (children.item(i) instanceof Element) {
				nodes[j++] = children.item(i);
			}
		}

		for (int i = 0; i < nodes.length; i++) {
			System.out.println("Node: " + nodes[i]);

		}
		for (int i = 0; i < nodes.length; i++) {
			System.out.println(nodes[i].getTextContent());
		}
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XmlToJavaObjectWithDomParser xml = new XmlToJavaObjectWithDomParser();
		xml.convertToJavaObject();
	}
}
