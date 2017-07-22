package generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import bookstore.Book;
import bookstore.Bookstore;


public class JavaObjToXmlConverter {
	public static void main(String[] args){
		Book book = new Book();
		book.setAuthor("J.K.Rowling");
		book.setDate(new Date());
		book.setTitle("Harry Potter");
		book.setCost(100);
		book.setPublisher("Publisher");
		book.setISBN(98653323232L);
		book.setId("harry_potter");
		
		Book book2 = new Book();
		book2.setAuthor("J. R. R. Tolkien");
		book2.setDate(new Date());
		book2.setTitle("The Hobbit");
		book2.setCost(100);
		book2.setPublisher("Publisher");
		book2.setISBN(98665323232L);
		book2.setId("hobbit");
		
		Book book3 = new Book();
		book3.setAuthor("Oscar Wilde");
		book3.setDate(new Date());
		book3.setTitle("The Picture of Dorian Gray");
		book3.setCost(150);
		book3.setPublisher("Publisher");
		book3.setISBN(98765677232L);
		book3.setId("dorian_gray");
		
		Book book4 = new Book();
		book4.setAuthor("Jane Austen");
		book4.setDate(new Date());
		book4.setTitle("Pride and Prejudice");
		book4.setCost(180);
		book4.setPublisher("Publisher");
		book4.setISBN(98765677232L);
		book4.setId("pride_prejudice");
		
		Book book5 = new Book();
		book5.setAuthor("Victor Hugo");
		book5.setDate(new Date());
		book5.setTitle("L'homme qui rit");
		book5.setCost(190);
		book5.setPublisher("Publisher");
		book5.setISBN(98765677232L);
		book5.setId("homme_qui_rit");
		
		Book book6 = new Book();
		book6.setAuthor("J. R. R. Tolkien");
		book6.setDate(new Date());
		book6.setTitle("The Lord of the Rings");
		book6.setCost(100);
		book6.setPublisher("Publisher");
		book6.setISBN(98665323232L);
		book6.setId("lord_rings");
		
		
		Bookstore bookstore = new Bookstore();
		List<Book> list = new ArrayList<>();
		list.add(book);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		list.add(book5);
		list.add(book6);
		bookstore.setBook(list);
		
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Bookstore.class);
			Marshaller jaxbMarshaller;
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(bookstore, new File("src/schema/bookstore.xml"));
			jaxbMarshaller.marshal(bookstore, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
}
