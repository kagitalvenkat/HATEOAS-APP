package in.rudra.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.rudra.entity.Book;

@RestController
public class BookRestController {

	@GetMapping(value = "/book/{isbn}", produces = "application/json")
	public Book getBookInfo(@PathVariable String isbn) {

		Book b = new Book(isbn, "JAVA", 582.25, "RUDRA");
		Link withRel = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookRestController.class).getAllBooks())
				.withRel("All-Books");
		b.add(withRel);
		return b;

	}

	@GetMapping(value = "/books", produces = "application/json")
	public List<Book> getAllBooks() {
		Book b1 = new Book("ISBN001", "JAVA", 582.25, "RUDRA");
		Book b2 = new Book("ISBN002", "SBMS", 452.22, "SAI");
		Book b3 = new Book("ISBN003", "ANGULAR", 785.33, "RITVIK");

		ArrayList<Book> al = new ArrayList<>();
		al.add(b1);
		al.add(b2);
		al.add(b3);

		return al;
	}

}
