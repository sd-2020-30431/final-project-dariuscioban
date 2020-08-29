package midi;

public class Note implements Comparable<Note>{
	private int frequency;
	private int duration;
	private int startTime;
	
	public Note(int frequency, int duration, int startTime) {
		this.frequency = frequency;
		this.duration = duration;
		this.startTime = startTime;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public int getDuation() {
		return duration;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public int compareTo(Note other) {
		return this.startTime - other.startTime;
	}
}
