package midi;

import java.util.ArrayList;
import java.util.Collections;

import javax.sound.midi.*;


public class Pattern implements Comparable<Pattern>, Runnable{
	
	private String name;
	private Midi midi;
	private int startTime;
	private Synthesizer synth;
	private Instrument instrument;
	private MidiChannel[] channels;
	
	public Pattern(String name, Midi midi, int startTime) {
		this.name = name;
		this.midi = midi;
		this.startTime = startTime;
		try {
			initialize();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initialize() throws MidiUnavailableException {
		synth = MidiSystem.getSynthesizer();
		synth.open();
		channels = synth.getChannels();
		//load with default
		instrument = synth.getDefaultSoundbank().getInstruments()[0];
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Midi getMidi() {
		return midi;
	}

	public void setMidi(Midi midi) {
		this.midi = midi;
	}
	
	public void loadInstrument(int number) {
		instrument = synth.getDefaultSoundbank().getInstruments()[number];
		synth.loadInstrument(instrument);
	}
	
	public void play() throws InterruptedException{
		channels[0].programChange(instrument.getPatch().getProgram());
		ArrayList<Note> notes = midi.getNotes();
		Collections.sort(notes);
		int time = 0;
		for(Note note : notes)
		{
			if(note.getStartTime() > time) {
				Thread.sleep(note.getStartTime() - time);
				time = note.getStartTime();
			}
			channels[0].noteOn(note.getFrequency(), 100);
			Thread.sleep(note.getDuation());
			channels[0].noteOff(note.getFrequency());
			time += note.getDuation();
		}
	}

	public synchronized void run() {
		try {
			Thread.sleep(startTime);
			play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int compareTo(Pattern other) {
		return this.startTime - other.startTime;
	}

}
