import javax.sound.midi.*;

import daw.Workstation;
import drumkit.*;
import midi.*;

public class Test {

	public static void main(String[] args) throws MidiUnavailableException {

		Midi m = new Midi(1);
		Midi m2 = new Midi(2);
		m.addNote(new Note(60, 500, 0));
		m.addNote(new Note(70, 1000, 1500));
		m.addNote(new Note(62, 100, 2500));
		m.addNote(new Note(63, 300, 500));
		m2.addNote(new Note(60, 500, 0));
		m2.addNote(new Note(70, 1000, 1500));
		m2.addNote(new Note(75, 100, 2500));
		m2.addNote(new Note(70, 300, 500));
		Pattern pattern = new Pattern("default", m, 0);
		pattern.loadInstrument(15);
		Pattern pattern2 = new Pattern("2nd", m2, 250);
		Drumkit dk = new Drumkit(0);
		for(int i = 0; i < 10; i++) {
			dk.addDrum(new Hat(400 * i));
		}
		dk.addDrum(new Clap(1010));
		dk.addDrum(new Kick(100));
		dk.addDrum(new Kick(800));
		dk.addDrum(new Kick(900));
		dk.addDrum(new Snare(1000));
		dk.addDrum(new Kick(1800));
		dk.addDrum(new Kick(1900));
		dk.addDrum(new Snare(2000));
		dk.addDrum(new Kick(2300));
		dk.addDrum(new Kick(2600));
		dk.addDrum(new Kick(2900));
		dk.addDrum(new Snare(3000));
		dk.addDrum(new Clap(3010));
		dk.addDrum(new Hat(3500));
		
		Workstation ws = new Workstation();
		ws.addPattern(pattern);
		ws.addDrumkit(dk);
		ws.addPattern(pattern2);
		
		Thread t1 = new Thread(pattern);
		Thread t2 = new Thread(pattern2);
		Thread t3 = new Thread(dk);
		
		//t1.start();
		//t2.start();
		//t3.start();
		
		try {
			ws.play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
