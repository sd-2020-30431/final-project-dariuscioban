package player;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

import midi.Note;
import midi.Pattern;

public class SoundPlayer {
	
	private Synthesizer synth;
	private Pattern pattern;
	
	public SoundPlayer() {
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			Soundbank bank = synth.getDefaultSoundbank();
	        synth.loadAllInstruments(bank);
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadPattern(Pattern pattern) {
		this.pattern = pattern;
		synth.getChannels()[0].programChange(pattern.getInstrument().getProgramId());
	}
	
	public void play() {
		for(Note note : pattern.getMidi().getNotes()) {
			synth.getChannels()[0].noteOn(note.getFrequency(), note.getDuation());
			try {
				Thread.sleep(note.getDuation());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
