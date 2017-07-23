package xpath;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlToJavaObjectXpathConverter {

	public void convertToJavaObject()
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse("src/schema/bookstore.xml");

		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("//book/*/text()");

		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;

		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}

		// return all book authors
		XPathExpression expr2 = xpath.compile("//book/author/text()");
		Object result2 = expr2.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes2 = (NodeList) result2;

		for (int i = 0; i < nodes2.getLength(); i++) {
			System.out.println(nodes2.item(i).getNodeValue());
		}

		// return all books by a particular author

		XPathExpression expr3 = xpath.compile("//book[contains(author, 'J. R. R. Tolkien')]/title/text()");
		Object result3 = expr3.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes3 = (NodeList) result3;

		for (int i = 0; i < nodes3.getLength(); i++) {
			System.out.println("The books by author are: " + nodes3.item(i).getNodeValue());
		}

		// return all books cheaper than 120$

		XPathExpression expr4 = xpath.compile("//book[cost < 120]/title/text()");
		Object result4 = expr4.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes4 = (NodeList) result4;

		for (int i = 0; i < nodes4.getLength(); i++) {
			System.out.println("Books cheaper than 120$ are : " + nodes4.item(i).getNodeValue());
		}

		// return all authors of the books which are more expensive than 150$

		XPathExpression expr5 = xpath.compile("//book[cost > 150]/author/text()");
		Object result5 = expr5.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes5 = (NodeList) result5;

		for (int i = 0; i < nodes5.getLength(); i++) {
			System.out.println(
					"Authors of the books which are more expensive than 120$: " + nodes5.item(i).getNodeValue());
		}
	}

	public static void main(String[] args) {
		XmlToJavaObjectXpathConverter xml = new XmlToJavaObjectXpathConverter();
		try {
			xml.convertToJavaObject();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
