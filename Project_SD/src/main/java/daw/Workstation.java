package daw;

import java.util.ArrayList;
import java.util.Collections;

import drumkit.Drumkit;
import midi.Pattern;

public class Workstation {
	
	ArrayList<Pattern> patterns;
	ArrayList<Drumkit> drums;
	
	public Workstation() {
		patterns = new ArrayList<Pattern>();
		drums = new ArrayList<Drumkit>();
	}
	
	public void play() throws InterruptedException {
		Collections.sort(patterns);;
		Thread[] threads = new Thread[patterns.size() + drums.size()];
		for(int i = 0; i < patterns.size(); i++) {
			threads[i] = new Thread(patterns.get(i));
		}
		for(int i = patterns.size(); i < patterns.size() + drums.size(); i++) {
			threads[i] = new Thread(drums.get(i - patterns.size()));
		}
		int time = 0;
		int drumsTime = 0;
		for(int i = 0; i < patterns.size(); i++) {
			if(patterns.get(i).getStartTime() > time) {
				Thread.sleep(patterns.get(i).getStartTime() - time);
				threads[i].start();
				time = patterns.get(i).getStartTime();
			}
			if(drums.size() > i && drums.get(i).getStartTime() > drumsTime) {
				Thread.sleep(drums.get(i).getStartTime() - drumsTime);
				threads[patterns.size() + i].start();
				drumsTime = drums.get(i).getStartTime();
			}
		}
	}
	
	public void addPattern(Pattern pattern) {
		patterns.add(pattern);
	}
	
	public void addDrumkit(Drumkit drumkit) {
		drums.add(drumkit);
	}
}
