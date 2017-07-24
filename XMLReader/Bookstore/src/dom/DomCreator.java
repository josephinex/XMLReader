package dom;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import student.Student;
import student.Students;

public class DomCreator {
	
	public Document createDocument(List<Student> list) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element root = doc.createElement("students");
		doc.appendChild(root);
		
		for (Student student : list) {
			Element studentElem = addElement(doc, root, "student", "");
			studentElem.setAttribute("id", Long.toString(student.getId()));
			
			addElement(doc, studentElem, "name", student.getName());
			addElement(doc, studentElem, "age", Integer.toString(student.getAge()));
			addElement(doc, studentElem, "id", Long.toString(student.getId()));
			addElement(doc, studentElem, "department", student.getDepartment());
			addElement(doc, studentElem, "universityYear", student.getUniversityYear());
		}
		
		return doc;	
	}

	private Element addElement(Document doc, Element parent, String elementName, String textValue) {
		Element childElem = doc.createElement(elementName);
		childElem.setTextContent(textValue);
		parent.appendChild(childElem);
		return childElem;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, 
	TransformerException {
		DomCreator domCreator = new DomCreator();
		Document doc = domCreator.createDocument(Students.getStudentList());
		
		//Create document using Transformer
		outputToString(doc);
		outputAsFile(doc, "src/schema/students.xml");
		
	}
	
	private static void outputAsFile(Document doc, String filename) 
			throws TransformerConfigurationException, 
			TransformerException, 
			TransformerFactoryConfigurationError {
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filename));
		getTransformer().transform(source, result);
	}

	private static void outputToString(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		DOMSource source = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		Transformer transformer = getTransformer();
		
		transformer.transform(source, result);
		
		String xmlString = writer.toString();
		System.out.println(xmlString);
	}

	private static Transformer getTransformer()
			throws TransformerFactoryConfigurationError, TransformerConfigurationException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		return transformer;
	}
	
}
