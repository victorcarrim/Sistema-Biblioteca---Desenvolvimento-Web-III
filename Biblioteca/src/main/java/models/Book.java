package models;

import java.sql.Date;
import java.time.LocalDate;

public class Book {
	private int id;
	private String name;
	private LocalDate date;
	private Author author;
	private BookStatus status;
	
	public Book(int id, String name, String date, Author author, Integer bookStatus) {
		setId(id);
		setName(name);
		setAuthor(author);
		setStatus(bookStatus);
		setDate(date);
	}
	
	public Book(int id, String name, Date date, Author author, Integer bookStatus) {
		setId(id);
		setName(name);
		setAuthor(author);
		setStatus(bookStatus);
		setDate(date);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public Date getDateDAO() {
		return Date.valueOf(this.date);
	}
	public void setDate(Date date) {
		this.date = date.toLocalDate();
	}
	public void setDate(String date) {
		this.date = LocalDate.parse(date);
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public BookStatus getStatus() {
		return status;
	}
	public void setStatus(Integer bookStatus) {
		if(bookStatus == 0) {
			this.status = BookStatus.AVAILABLE;
		} else if(bookStatus == 1) {
			this.status = BookStatus.UNAVAILABLE;
		} else if(bookStatus == 2) {
			this.status = BookStatus.BORROWED;
		}
	}
	
	
}
