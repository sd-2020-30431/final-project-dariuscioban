package midi;

import java.util.ArrayList;

public class Midi {
	
	private ArrayList<Note> notes;
	private int steps;
	
	public Midi(int steps) {
		this.steps = steps;
		notes = new ArrayList<Note>();
	}
	
	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	public int getSteps() {
		return steps;
	}
	
	public void addNote(Note note) {
		notes.add(note);
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}
}
