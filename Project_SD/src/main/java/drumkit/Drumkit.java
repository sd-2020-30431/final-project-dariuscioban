package drumkit;

import java.util.ArrayList;
import java.util.Collections;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Drumkit implements Runnable, Comparable<Drumkit>{
	
	private int startTime;
	private Synthesizer synth;
	private MidiChannel channel;
	private ArrayList<Drum> drums;
	
	public Drumkit(int startTime) {
		this.startTime = startTime;
		drums = new ArrayList<Drum> ();
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
		channel = synth.getChannels()[9];
	}
	
	public void addDrum(Drum drum) {
		drums.add(drum);
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public void play() throws InterruptedException{
		Collections.sort(drums);
		int time = 0;
		for(Drum drum : drums)
		{
			if(drum.getStartTime() > time) {
				Thread.sleep(drum.getStartTime() - time);
				time = drum.getStartTime();
			}
			channel.noteOn(drum.getPadNumber(), 100);
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

	public int compareTo(Drumkit other) {
		return this.startTime - other.startTime;
	}
}
