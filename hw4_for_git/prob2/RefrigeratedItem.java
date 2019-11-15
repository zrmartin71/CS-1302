package prob2;

public class RefrigeratedItem extends Item {
	protected double temp;
	
	public RefrigeratedItem(String name, double weight, double temp) {
		super(name, weight);
		this.temp= temp;
	}
	
	public RefrigeratedItem(Item item, double temp) {
		this(item.getName(), item.getWeight(), temp);
		this.temp= temp;
	}
	
	public double getTemp() {
		return this.temp;
	}
	
	public double cost() { 
		double cost= (weight * 2 + (100-temp)*0.1);
		return cost;
	}
	
	@Override
	public String toString() {	
		return String.format("Name= %s, Cost= $%,.2f, Weight= %.2f, Temp= %.2f degrees", name, cost(), weight, temp);
	}

}
