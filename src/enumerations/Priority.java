package enumerations;

public enum Priority {
	HIGH(1),
	LOW(2),
	MEDUIM(3);
	
	private int prioIndex;
	
	private Priority(int p) {
		this.prioIndex = p;
	}
	
	public int getPrioIndex() 
	{
		return this.prioIndex;
	}
}
