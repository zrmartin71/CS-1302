package prob2;
import java.util.ArrayList;

public class Warehouse {
	protected ArrayList<Item> items= new ArrayList<>();
	
	public ArrayList<Item> addItem(Item item) {
		items.add(item);
		return items;
	}
	
	public Item getItem(Item item) {
		if(items.contains(item)) {
			return items.get(items.indexOf(item));
		}
		
		return null;
	}
	
	public Item getItem(String name) {
		Item dummy= new Item(name,0);
		if(items.contains(dummy)) {
			return getItem(dummy);
		}
		
		return null;
	}
	
	public int getNumItems() {
		int count= 0;
		for(int i= 0; i < items.size(); i++){
			if(items.get(i) != null) {
				count++;
			}
		}
		
		return count;
	}
	
	public ArrayList<RefrigeratedItem> getRefrigeratedItems(){ //needs testing
		ArrayList<RefrigeratedItem> coldItems= new ArrayList<>();
		for(int i= 0; i < items.size(); i++) {
			if(items.get(i) instanceof RefrigeratedItem) { 
				RefrigeratedItem dummy= (RefrigeratedItem) items.get(i);
				 coldItems.add(dummy);
			}
			
		}
		
		return coldItems;
	}
	
	public double getTotalCost() {
		double totalCost= 0;
		for(int i= 0; i < items.size(); i++) {
			totalCost += items.get(i).cost();
		}
		
		return totalCost;
	}
	
	public double getTotalCostRefrigerated() { //needs testing
		double totalRefrigCost= 0;
		for(int i= 0; i < items.size(); i++) {
			if(items.get(i) instanceof RefrigeratedItem) { 
				RefrigeratedItem dummy= (RefrigeratedItem) items.get(i);
				 totalRefrigCost += dummy.cost();
			}
			
		}
		
		return totalRefrigCost;
	}
	
	public Item removeItem(Item item) { //works for now; improve later if you have time
		if(items.contains(item)) {
			items.get(items.indexOf(item));
			return items.remove(items.indexOf(item));
		}
		
		return null;
	}
	
	public String toString() { //probs wont work but it does the job for now
		String toString= "";		 
		for(int i= 0; i < items.size(); i++) {
			toString += items.get(i).toString() + "\n";
		}
		
		return toString;
	}

}
