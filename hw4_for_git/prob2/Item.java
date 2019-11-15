package prob2;

public class Item {
	protected String name;
	protected double weight;
	
	public Item(String name, double weight) {
		this.name= name;
		this.weight= weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public double cost() {
		double cost= weight * 2;
		return cost;
	}
	
	public boolean equals(Object o) {
		Item i= (Item) o;			
		return this.getName().equals(i.getName());
	}
	
	@Override
	public String toString() {	
		return String.format("Name= %s, Cost= $%,.2f, Weight= %.2f", name, cost(), weight);
	}

}
