package midi;

public class Instrument {
	
	private String name;
	private int programId;
	
	public Instrument(String name, int bankId, int programId) {
		this.name = name;
		this.programId = programId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getProgramId() {
		return programId;
	}
}
