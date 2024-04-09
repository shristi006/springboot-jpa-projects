package vw.springbootreact.bookapp.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	private int id;
	
	private String bkname;
	private double bkprice;
	
	
	public Book() {
		
	}
	
	
	public Book(int id, String bkname, double bkprice) {
		super();
		this.id = id;
		this.bkname = bkname;
		this.bkprice = bkprice;
	}

	//getter setter methods
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBkname() {
		return bkname;
	}


	public void setBkname(String bkname) {
		this.bkname = bkname;
	}


	public double getBkprice() {
		return bkprice;
	}


	public void setBkprice(double bkprice) {
		this.bkprice = bkprice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", bkname=" + bkname + ", bkprice=" + bkprice + "]";
	}
	
	//to string 
	
	
	
	
	
}
