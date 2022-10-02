import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DecimalCounter {
	/**
	 * 0000 0001 0010 0011 0100 0101 0110 0111 1000 1001 
	 */
	
	private final static int DECIMAL = 10;	
	private int current;
	private int newCurrent;
	private List<Integer> counter;	
	{
		counter = defaultInit();
	}	
	
	public DecimalCounter(int current) {
		super();
		this.setCurrent(current);
	}	

	public DecimalCounter(int current, int newCurrent) {
		super();
		this.current = current;
		this.newCurrent = newCurrent;
	}

	public static List<Integer> defaultInit() {		
		Integer [] arr = new Integer [DECIMAL];
		for (int i = 0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		return Arrays.asList(arr);
	}	
	
	public static List<Integer> randomInit() {		
		Integer [] arr = new Integer [DECIMAL];
		int i = 0;
		while(i<arr.length) {
			IntSupplier supplier = ()->(int)(Math.random()*10);
			Integer number = supplier.getAsInt();
			if(Stream.of(arr).noneMatch(x -> x==number)) {
				arr[i]=number;
				i++;
			}
		}
		
		return Arrays.asList(arr);
	}
	
	public List<Integer> getCounter() {
		return counter;
	}

	public void setCounter(List<Integer> counter) {
		this.counter = counter;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}			
	
	public int getNewCurrent() {
		return newCurrent;
	}

	public void setNewCurrent(int newCurrent) {
		this.newCurrent = newCurrent;
	}

	public void changePosition() {
		int cur = getCurrent();
		int nCur = getNewCurrent();
		List<Integer> list = getCounter();
		Collections.sort(list);//for random number
		
		Predicate<Integer> predicate;
		
		if(cur<nCur) {
			predicate = n -> n>cur && n<=nCur;
		}else {
			predicate = n -> n<cur && n>=nCur;
			Collections.reverse(list);			
		}		
		
		Supplier<Integer> switchPosition = ()->{			
			for(Integer n: list)  {
	            if(predicate.test(n)) {	            	
	            	setCurrent(n);
	                System.out.println("switch..."+function().apply(getCurrent()) + " ");
	            }
	        }
			return getCurrent();
		};
		
		System.out.println("New position: "+function().apply(switchPosition.get()));		
	}
	
	
	public Function<Integer, String> function(){		
		return t ->String.format("%4s", Integer.toBinaryString(t)).replace(' ', '0');		
	}
	
	public String print() {		
		return(function().apply(getCounter().get(getCurrent())));
	}
	
	@Override
	public String toString() {
		//Function<Integer, String> function = t ->String.format("%4s", Integer.toBinaryString(t)).replace(' ', '0');
		//counter.stream().map(function()).forEach(x->System.out.print(x+" "));				
		return counter.stream().map(function()).collect(Collectors.toList()).toString();
	}
	
}
