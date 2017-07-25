package sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import student.Student;

public class SaxParser {
	
	public void parseXml() {
		
	}
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SaxStudentHandler saxHandler = new SaxStudentHandler();
		List<Student> data = saxHandler.readDataFromXml("src/schema/students.xml");
		
		for (Student student : data) {
			System.out.println(student);
		}
	}
}
