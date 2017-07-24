package dom;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import error.handler.ErrorsHandler;

public class DomParserXml {

	public void displayXmlContent() throws IOException {
		File file = new File("src/schema/bookstore.xml");
		StringBuilder builder = new StringBuilder();
		FileReader reader = new FileReader(file);
		
		int content;
		while((content = reader.read()) != -1) {
			builder.append((char)content);
		}
		reader.close();
		System.out.println("Builder " + builder.toString());
	}

	public void convertToJavaObject() throws ParserConfigurationException, SAXException, IOException {
		ErrorsHandler errHandler = new ErrorsHandler();
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		domFactory.setValidating(true);
		domFactory.setIgnoringElementContentWhitespace(true); // remove whitespace while parsing

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
		Node node = subList.item(0); // first book
		NodeList children = node.getChildNodes(); // children of first book

		List<Element> nodes = new ArrayList<>();

		for (int i = 0; i < children.getLength(); i++) {
			short type = children.item(i).getNodeType();

			if (type == Node.TEXT_NODE) {
				String value = children.item(i).getNodeValue().trim();// trim spaces from text node
				System.out.println("Node Value trimmed: " + value);
				System.out.println("Content is: " + ((Text) children.item(i)).getWholeText());
				System.out.println("Node Value: " + children.item(i).toString());
				System.out.println("Is whitespace: " + ((Text) children.item(i)).isElementContentWhitespace());
				System.out.println("Text content: " + children.item(i).getTextContent());
			}

			if (children.item(i) instanceof Element) {
				nodes.add((Element) children.item(i));
			}
		}

		for (int i = 0; i < nodes.size(); i++) {
			System.out.println("Node -> " + nodes.get(i).getNodeName() + " : " + nodes.get(i).getTextContent());
		}

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DomParserXml xml = new DomParserXml();
		xml.displayXmlContent();
		xml.convertToJavaObject();

	}
}
