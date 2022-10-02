
public enum Topic {
	
	ARRAYS_SYMBOL(5), OBJECT_STRINGS(10), REGULAR_EXPRESSIONS(2);
	
	private int number;//number of tasks in the topic	

	private Topic(int number) {
		this.number = number;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
		
	public TaskSelection task() {
		TaskSelection ts=null;
				
		switch (this) {
        case ARRAYS_SYMBOL:
        	ts = new ArraysSymbol();
            break;
        case OBJECT_STRINGS:
        	ts = new ObjectStrings();
            break;  
        case REGULAR_EXPRESSIONS:
        	ts = new RegularExpressions();
            break;       
        }		
		
		return ts;
	}
	
}
