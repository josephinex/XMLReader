package bookstore;
import javax.xml.bind.JAXBException;

import generator.XsdGenerator;

public class Main {

	public static void main(String[] args) {
		XsdGenerator xsd = new XsdGenerator();
		try {
			xsd.generateXsdSchema();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
