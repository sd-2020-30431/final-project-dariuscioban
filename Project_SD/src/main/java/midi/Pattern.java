package midi;

public class Pattern {
	
	private String name;
	private Midi midi;
	private Instrument instrument;
	
	public Pattern(String name, Midi midi, Instrument instrument) {
		this.name = name;
		this.midi = midi;
		this.instrument = instrument;
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

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	

}
