package prob2;

public class RedMartian extends Martian {
	
	public RedMartian (int id) {
		super(id);
	}
	
	@Override
	public String speak() {
		return String.format("id= %d, Rubldy Rock", this.getId()); 
	}
	
	@Override
	public String toString() {
		return String.format("Red Martian - id= %d, vol= %d", this.getId(), super.getVolume());
	}

}
