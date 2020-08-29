package drumkit;

public abstract class Drum implements Comparable<Drum> {
	
	private int startTime;
	
	public Drum(int startTime) {
		this.startTime = startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public abstract int getPadNumber();
	
	public int compareTo(Drum other) {
		return this.startTime - other.startTime;
	}
}
