package bookstore;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace="", name="bookstore")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookstore", propOrder = {
	    "book"
	})
public class Bookstore implements Serializable{
	
	private static final long serialVersionUID = -7844966642164040872L;
	
	@XmlElement 
	List<Book> book;

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}


}
