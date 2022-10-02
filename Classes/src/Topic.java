
public enum Topic {
	
	SIMPLE(10), OBJECTS_CLASS(5);
	
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
        case SIMPLE:
        	ts = new Simple();
            break;
        case OBJECTS_CLASS:
        	ts = new ObjectsClass();
            break;  
		}
		
		return ts;
	}	
}
