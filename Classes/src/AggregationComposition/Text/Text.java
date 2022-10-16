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
				                StringBuilder::new, // �����_�������������_������������
				                (b, s) -> b.append(s).append("\n"), // �����_���������_�������_��������,
				                (b1, b2) -> b1.append(b2).append(" , "), // �����_����������_����_�������������
				                StringBuilder::toString // �����_���������_���������_������������
				        )
				);
		
		setText(joinBuilder);		
	}	

	@Override
	public String toString() {
		return "Title -> "+title+"\nText -> "+text;
	}

	public void newtext(String newText) {
		//join() � ����������� ������ �������� � ������
		String[] ss = {getText(), "["+newText+"]"};		
		setText(String.join("", ss));
	}

	
	


	
}
