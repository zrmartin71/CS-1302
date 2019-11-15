package prob2;
import java.util.ArrayList;
import java.util.Collections;
public class MartianManager implements Cloneable {
	protected ArrayList<Martian> martians = new ArrayList<>();
	protected ArrayList<Teleporter> teleporters = new ArrayList<>();
	
	//test 0 Martians
	RedMartian r1= new RedMartian(1);
	RedMartian r2= new RedMartian(2);
	GreenMartian g1= new GreenMartian(1);
	GreenMartian g2= new GreenMartian(2);
	
	public boolean addMartian(Martian m){
		if(!(martians.contains(m))) {
			martians.add(m);
		}
		
		if(m instanceof GreenMartian) {
			GreenMartian g= (GreenMartian) m;
			teleporters.add(g);
		}
		
		return false;
	}
	
	public String groupSpeak() {
		String allSpeak= "";
		for(int i= 0; i < martians.size(); i++) {
			allSpeak+= String.format("%s\n", martians.get(i).speak());
		}
		
		return allSpeak;
	}
	
	public String groupTeleport(String dest) {
		String allTele= "";
		for(int i= 0; i < teleporters.size(); i++) {
			allTele+= String.format("%s\n", teleporters.get(i).teleport(dest));
		}
		
		return allTele;
	}
	
	public int getNumMartians() {
		//return martians.size();
		int count= 0;
		for(int i= 0; i < martians.size(); i++) {
			count++;
		}
		
		return count;
	}
	
	public int getNumTeleporters() {
		int count= 0;
		for(int i= 0; i < martians.size(); i++) {
			if(martians.get(i) instanceof GreenMartian) {
				count++;
			}
		}
		
		return count;
	}
	
	public Martian getMartianAt(int i) {
		if(0 <= i && i <= martians.size()-1) {
			return martians.get(i);
		}
		
		return null;
	}
	
	public Teleporter getTeleporterAt(int i) {
		if(0 <= i && i <= teleporters.size()-1) {
			return teleporters.get(i);
		}
		
		return null;
	}
	
	public Martian getMartianWithId(int id) {
		RedMartian dummy= new RedMartian(id);
		for(int i= 0; i < martians.size(); i++) {
			if(martians.contains(martians.get(id))) {
				dummy= (RedMartian) martians.get(id);
				return dummy;
			}
		}
		
		return null;
	}
	
	public Martian getMartianClosestTo(int id) {
		int minId= Integer.MAX_VALUE;
		int diff= 0;
		Martian closest = null;
		for(int i= 0; i < martians.size(); i++) {
			diff= Math.abs(martians.get(i).getId() - id);
			if(diff < minId) {
				minId= diff;
				closest= martians.get(i);
			}
		}
		
		return closest; 
	}
	
	public boolean removeMartian(int id) {
		GreenMartian dummy= new GreenMartian(id);
		int indxOfRemoval;
		for(int i= 0; i < martians.size(); i++) {
			if(martians.contains(dummy)) {
				indxOfRemoval= martians.indexOf(dummy);
				martians.remove(indxOfRemoval);
				if(teleporters.contains(dummy) && dummy instanceof GreenMartian) {
					Teleporter t= (Teleporter) dummy;
					teleporters.remove(t);
				}
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Martian> sortedMartians() throws CloneNotSupportedException{
		ArrayList<Martian> sortedMartians= new ArrayList<>();
		for(Martian s: this.martians) {
			sortedMartians.add((Martian) s.clone()); 
		}
		
		//this.martians= sortedMartians;
		Collections.sort(sortedMartians);
		
		return sortedMartians;
	}
	
	public void obliterateTeleporters() {
		for(int i= 0; i < teleporters.size(); i++) {
			if(teleporters.get(i) instanceof GreenMartian) {
				Martian obliterated= (Martian) teleporters.get(i);
				martians.remove(martians.indexOf(obliterated));
			}
		}
		teleporters.clear();	
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		MartianManager manager2= (MartianManager) super.clone();
		ArrayList<Martian> cMartians= new ArrayList<>();
		for(Martian m : martians) {
			cMartians.add((Martian) m.clone());
		}
		
		manager2.martians= cMartians;
		return manager2;
	}

}
