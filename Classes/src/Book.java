import java.math.BigDecimal;

public class Book {
	
	private int id;
	private static int ID=1;
	
	private String title;
	private String author;
	private String publishing;
	private int year;
	private int numberPage;
	private BigDecimal price;
	private BookType typeOfBinding;
	
	public Book(int id, String name, String author, String publishing, int year, int numberPage, BigDecimal price,
			BookType typeOfBinding) {
		super();
		this.id = ID++;
		this.title = name;
		this.author = author;
		this.publishing = publishing;
		this.year = year;
		this.numberPage = numberPage;
		this.price = price;
		this.typeOfBinding = typeOfBinding;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberPage() {
		return numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BookType getTypeOfBinding() {
		return typeOfBinding;
	}

	public void setTypeOfBinding(BookType typeOfBinding) {
		this.typeOfBinding = typeOfBinding;
	}

	@Override
	public String toString() {
		return "Book "+id+" [title=" + title + ", author=" + author + ", publishing=" + publishing + ", year="
				+ year + ", numberPage=" + numberPage + ", price=" + price + ", typeOfBinding=" + typeOfBinding + "]";
	}
		
}
