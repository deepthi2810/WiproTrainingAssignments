package lms;

public class Book 
{
	private String bookTitle;
	private String bookCategory;
	private String Author;
	private int Price;
	
	public Book() {}
	
	public Book(String bookTitle, String bookCategory, String author, int price) {
		super();
		this.bookTitle = bookTitle;
		this.bookCategory = bookCategory;
		Author = author;
		Price = price;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Book [bookTitle=" + bookTitle + ", bookCategory=" + bookCategory + ", Author=" + Author + ", Price="
				+ Price + "]";
	}

	
	
}
