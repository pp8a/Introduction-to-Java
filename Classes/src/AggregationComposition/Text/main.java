package Text;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
				
		String str = "Since 1993, we’ve relied on our Engineering DNA to underpin our work with clients "
				+ "leading to major innovations, digital transformations and business results."
				+ " In that time, we’ve expanded geographically, as well as extended our core engineering"
				+ " capabilities to include business consulting, design and physical product development.";
				
		
		Sentence sentence = new Sentence(str);
		sentence.words();//set words
		
		List<Word> list = Stream.of(sentence.getWords()).collect(Collectors.toList());
		System.out.print("Words -> ");
		list.forEach(t -> System.out.print(t.toString()));
				
		sentence.sentences(list);//set sentence
		System.out.print("\n");
		Stream.of(sentence.getWords()).forEach(t->System.out.println("Sentence -> "+t));		

		Text text = new Text(sentence.getWord(), sentence.getWords());		
		text.text(text.getWords());//set text		
		Stream.of(text.getText()).forEach(t->System.out.println("\nText -> "+t));
		
		text.setTitle("Our History");
		Text textTitle = new Text(sentence.getWord(), text.getText(), text.getTitle());
		Stream.of(textTitle).forEach(System.out::println);
		
		String newText = "We’ve been at the forefront of some of the most exciting technology-led transformations in the industry, "
				+ "and our story continues into today’s modern age of agile delivery, big data, machine learning and AI.";
		textTitle.newtext(newText);
		Stream.of(textTitle).forEach(t->System.out.println("New text -> "+newText+"\nadd:\n"+t));		
		
	}

}
