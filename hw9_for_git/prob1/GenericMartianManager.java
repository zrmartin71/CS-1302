package prob1;

import java.util.ArrayList;

public class GenericMartianManager<E extends Martian> {
	protected ArrayList<E> martians = new ArrayList<>();
	
	public boolean addMartian(E m) {
		if(!(martians.contains(m))) {
			martians.add((E) m); //used quick fix 
			return true;
		}
		return false;
	}
	
	public int getNumMartians() {
		return martians.size();
	}
	
	public E getMartian(E m) {
		for(int i= 0; i < martians.size(); i++) {
			if(martians.get(i).equals(m)) {
				return martians.get(martians.indexOf(m));
			}
		}
		return null;
	}
	
	public void mergeMartians(ArrayList<? extends Martian> marts){
		for(int i = 0; i < marts.size(); i++) {
			martians.add((E) marts.get(i));
		}
	}
	
	public boolean removeMartian(E m) {
		if(martians.contains(m)) {
			martians.remove(m);
			return true;
		}
		return false;
	}
}
