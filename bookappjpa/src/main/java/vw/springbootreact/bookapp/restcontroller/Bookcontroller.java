package vw.springbootreact.bookapp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import vw.springbootreact.bookapp.dao.Bookdao;
import vw.springbootreact.bookapp.exception.BookNotFoundException;
import vw.springbootreact.bookapp.model.Book;

@RestController

@CrossOrigin(origins = {"http://localhost:3000"})
public class Bookcontroller {

	@Autowired
	Bookdao bookdao;
	
	@GetMapping()
	public String home() {
		return "Book Application Home page";
	}
	@GetMapping("greet")
	public String greet() {
		return "Hello it works";
	}
	
	
	@GetMapping("books")
	public ResponseEntity<List<Book>> getAllBooks(){
		
		List<Book> barr=this.bookdao.getallbooks();
		return new ResponseEntity<>(barr,HttpStatus.OK);
	}
	
	@GetMapping("books/{bookid}")
	public ResponseEntity<Book> getBookWithId(@PathVariable int bookid) {
		
		
		try {
			Book b=this.bookdao.getBookById(bookid);
			return new ResponseEntity<>(b,HttpStatus.OK);
		}
		catch(BookNotFoundException e) {
			
			 throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Book not found" ,e);
		}
	}
	
	@PostMapping("books/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book b) {
		
//		boolean flag=
		Book b1=this.bookdao.addbook(b);
		
//		if(flag) {
//			return "Book with bookid:"+b.getId()+" added successfully";
//		}
//		else {
//			return "Unable to add book:"+b;
//		}
		return new ResponseEntity<>(b1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("books/deletebook/{bookid}")
	public ResponseEntity<Book> deleteBook(@PathVariable int bookid) {
		
		Book b=this.bookdao.deleteBook(bookid);
		
		 return new ResponseEntity<>(b,HttpStatus.OK);
		
	}
	
	@PutMapping("books/updatebook/{bookid}")
	public ResponseEntity<Book> putEmp(@PathVariable int bookid ,@RequestBody Book b)
	{
		
		String status = this.bookdao.updateBook(bookid,b);
		
		if(status.equals("updated"))
		  return new ResponseEntity<>(b, HttpStatus.OK);
		else if(status.equals("added"))
		  return new ResponseEntity<>(b, HttpStatus.CREATED);
		else
		 return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);	
		
	}
}
