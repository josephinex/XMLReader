package jaxb.generator;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;

import bookstore.Bookstore;

public class XsdGenerator {
	
	public void generateXsdSchema() throws JAXBException{	
		JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);
		SchemaOutputResolver sor = new MySchemaOutputResolver();
	
		try {
			jaxbContext.generateSchema(sor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
