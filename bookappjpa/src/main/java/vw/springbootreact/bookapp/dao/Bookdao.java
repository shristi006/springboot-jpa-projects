package vw.springbootreact.bookapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vw.springbootreact.bookapp.exception.BookNotFoundException;
import vw.springbootreact.bookapp.model.Book;
import vw.springbootreact.bookapp.repo.BookSpringDataJpaRepo;

@Service
public class Bookdao {

	@Autowired
	BookSpringDataJpaRepo  brp;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public Book addbook(Book b) {
		Book b1=brp.save(b);
		return b1;
		
	}
	
	
	public List<Book> getallbooks(){
		
		return this.brp.findAll();
	}
	
	public Book getBookById(int id) {
		
		Optional<Book> b=brp.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		else {
			throw new BookNotFoundException("Book with id:"+ id+" does not exist in database");
		}
	}
	
	
	public Book deleteBook(int id) {
		
		
		Book b= this.brp.deleteById(id);
		
		return b;

		 
	}
	
	public String updateBook(int id,Book b)
	{
		String status ="";
		Book b1=getBookById(id);
		if(b1!=null)
		{
			this.brp.save(b);
			status = "updated";
		}
		else
		{
			logger.info("Book :"+b+" not found in list so adding it..");
			this.brp.save(b);
			status = "added";
		}
		return status;
	}
}
