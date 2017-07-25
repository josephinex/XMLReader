package sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import student.Student;

public class SaxStudentHandler extends DefaultHandler {

	private List<Student> data;
	private Student student;
	private String currentElement;
	private StringBuilder currentText;
	
	public List<Student> readDataFromXml(String filename)
			throws SAXException, IOException, ParserConfigurationException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		parser.parse(new File(filename), this);
		return data;
	}

	@Override
	public void startDocument() throws SAXException {
		data = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End Document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentElement = qName;
		
		switch (currentElement) {
		case "students":
			break;
		case "student":
			student = new Student();
			String idAsString = attributes.getValue("id");
			student.setId(Long.parseLong(idAsString));
			data.add(student);
			break;
		default:
			currentText = new StringBuilder();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(currentElement.equals("student") || currentElement.equals("student")) {
			return;
		}
		String content = currentText.toString();
		switch (currentElement) {
		case "name":
			student.setName(content);
			break;
		case "age":
			student.setAge(Integer.parseInt(content));
			break;
		case "id":
			student.setId(Long.parseLong(content));
			break;
		case "department":
			student.setDepartment(content);
			break;
		case "universityYear":
			student.setUniversityYear(content);
			break;
		default:
			break;
		}
		currentElement = "";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(currentText != null) {
			currentText.append(ch, start, length);
		}
	}
}
