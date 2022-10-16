package Text;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sentence extends Word{

	private Word[] words;
	
	public Sentence(String word) {
		super(word);
	}

	public Sentence(String word, Word[] words) {
		super(word);
		this.words = words;
	}

	public Word[] getWords() {
		return words;
	}

	public void setWords(Word[] words) {
		this.words = words;
	}
		
	@Override
	public String toString() {		
		return "Sentences -> " + Arrays.toString(words);
	}
	
	private static Matcher splitWord(String sentence) {
		
		final String WORD = "[a-zA-Zа-яА-Я0-9-ёЁ’.]+";
		
		Pattern pWord = Pattern.compile(WORD);		
		Matcher mWord = pWord.matcher(sentence);
		
		return mWord;		
	}

	public static int wordCount(String sentence) {
		/**
		 * @return word count in sentence
		 */
		
		Matcher mWord = splitWord(sentence);
		
		int wCount = 0;
		while(mWord.find()) {
			wCount++;
		}
		//System.out.println("Количество слов: " + count);
		
		return wCount;
	}
	
	public void words() {
		String sentence = getWord();		
		int wCount = wordCount(sentence);
		Matcher mWord = splitWord(sentence);
		
		words = new Word[wCount];
		
		int i=0;
		while(mWord.find()) {
			int start=mWord.start();
	        int end=mWord.end();	        
	        
	        String word = sentence.substring(start,end);
	        words[i++]=new Word(word);
		}
		
		setWords(words);			
	}
	
	private static Matcher splitSentence(String str) {
		
		final String SENTENCE = ".+?[.!?]";
		
		Pattern pSentence = Pattern.compile(SENTENCE);		
		Matcher mSentence = pSentence.matcher(str);
		
		return mSentence;		
	}
	
	public static int sentenceCount(String paragraph) {
		
		Matcher mSentence = splitSentence(paragraph);			
        int count = 0;
        while(mSentence.find()) {
        	count++;
        	//System.out.println("Количество предложений: " + count);
        }		
		return count;
	}
	
	public void sentences(List<Word> list) {
		
		int wSentence = sentenceCount(list.toString());
		Word[] arrSentence = new Word[wSentence];
		
		int i=0; 
		String s = "";
		for (Word word : list) {
			
			StringBuilder sb = new StringBuilder(s);
			sb.append(word.getWord()+" ");
			s = sb.toString();
			
			Matcher mSentence = splitSentence(word.toString());
			if(mSentence.find()) {										
				arrSentence[i++]=new Word(s.strip());//trim()
				s="";
			}
		}	

		setWords(arrSentence);
	}

}
