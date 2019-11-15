package prob2;

public class GreenMartian extends Martian implements Teleporter{
	
	public GreenMartian(int id) {
		super(id);
	}
	
	@Override
	public String speak() {
		return String.format("id= %d, Grobly Grock", this.getId());
	}
	
	@Override
	public String teleport(String dest) {
		return String.format("id= %d teleporting to %s", this.getId(), dest);
	}
	
	@Override
	public String toString() {
		return String.format("Green martian - id= %d, vol= %d", this.getId(), this.getVolume());
	}

}
