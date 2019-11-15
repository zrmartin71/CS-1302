package prob2;

public abstract class Martian implements Comparable<Martian>, Cloneable {
	private int id;
	private int volume;
	
	public Martian(int id){
		this.id= id;
		this.volume= 1;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public void setVolume(int level) {
		volume= level;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public int compareTo (Martian m) {
		return this.getId()-m.getId();
//		if(this.getId() < m.getId()) {
//			return m.getId();
//		}
//		
//		return this.getId();
	}
	
	@Override
	public boolean equals(Object o) {
		Martian m= (Martian) o;
		return getId() == m.getId();
	}
	
	public abstract String speak();
	
	public String toString() {
		return String.format("id= %d, vol= %d", id, volume);
	}

}
