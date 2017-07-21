package generator;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import bookstore.Bookstore;

public class XmlToJavaObjectConverter {
	public static void main(String[] args) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Bookstore bookstore = (Bookstore) jaxbUnmarshaller.unmarshal(new File("src/generator/bookstore.xml"));
			System.out.println(bookstore);
			System.out.println(bookstore.getBook().get(0).getAuthor());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
