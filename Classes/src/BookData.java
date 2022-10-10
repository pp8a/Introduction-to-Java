import java.math.BigDecimal;
import java.util.Scanner;

public class BookData {

	private static Book [] books;

	public BookData(Book[] books) {
		super();
		BookData.books = books;
	}

	public Book[] getBooks() {
		return books;
	}

//	public void setBooks(Book[] books) {
//		BookData.books = books;
//	}	
	
	public static BookData initData() {		
		
		Book book_0 = new Book(0, "На войне в Азии и Европе", "Василий Верещагин", "ДМК Пресс", 2015, 312, 
				new BigDecimal("63.4"), BookType.HARDCOVER);
		Book book_1 = new Book(0, "Распределенные системы.", "Эндрю С. Таненбаум", "ДМК Пресс", 2020, 584, 
				new BigDecimal("162.1"), BookType.HARDCOVER);
		Book book_2 = new Book(0, "Учебник-самоучитель по трехмерной графике Blender 3D.", "Мария Серова", "Солон-Пресс", 2021, 272, 
				new BigDecimal("55.9"), BookType.SINGER_SEWN_BINDING);
		Book book_3 = new Book(0, "12 элементов успешного менеджмента.", "Род Вагнер", "Алгоритм", 2019, 248, 
				new BigDecimal("49.2"), BookType.HARDCOVER);
		Book book_4 = new Book(0, "25 граммов счастья.", "Массимо Ваккетта", "Эксмо", 2021, 176, 
				new BigDecimal("32.1"), BookType.SADDLE_STITCH_BINDING);
		Book book_5 = new Book(0, "1812. Они воевали с Наполеоном.", "Василий Верещагин", "Алгоритм", 2020, 272, 
				new BigDecimal("40.9"), BookType.SPIRAL_BINDING);
		Book book_6 = new Book(0, "Очерки, наброски, воспоминания", "Василий Верещагин", "Алгоритм", 2014, 202, 
				new BigDecimal("51.6"), BookType.COPTIC_STITCH_BINDING);
		
		books = new Book[] {book_0, book_1, book_2, book_3, book_4, book_5, book_6};
		
		return new BookData(books);
	}
	
	public static String input() {		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		String str = in.nextLine();
		return str;
	}
	
	public static int inputNumber() {		
		int number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
					
		while (!in.hasNextInt()) {
			System.err.println("It's not an integer number! ... Input:");
			in.next(); 
		}
		number = in.nextInt();
		if(number<=0) {
			System.out.println("Input only positive number! ... Input:");
		}		
		
		return number;
	}
}
