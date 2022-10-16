package Text;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;

public class Text extends Sentence{
	
	private String text;
	private String title;
	
	public Text(String word, Word[] words) {
		super(word, words);
		// TODO Auto-generated constructor stub
	}
	
	public Text(String word, String text, String title) {
		super(word);
		this.text = text;
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String joinBuilder) {
		this.text = joinBuilder;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void text(Word[] words) {
		
		Collection<Word> strings = Arrays.asList(words);
		String joinBuilder = strings.stream().collect(
				   Collector.of(
				                StringBuilder::new, // метод_инициализации_аккумулятора
				                (b, s) -> b.append(s).append("\n"), // метод_обработки_каждого_элемента,
				                (b1, b2) -> b1.append(b2).append(" , "), // метод_соединения_двух_аккумуляторов
				                StringBuilder::toString // метод_последней_обработки_аккумулятора
				        )
				);
		
		setText(joinBuilder);		
	}	

	@Override
	public String toString() {
		return "Title -> "+title+"\nText -> "+text;
	}

	public void newtext(String newText) {
		//join() — преобразует массив подстрок в строку
		String[] ss = {getText(), "["+newText+"]"};		
		setText(String.join("", ss));
	}

	
	


	
}
