package prob1;

public class ClassicYellowCake extends Cake {
	
	public ClassicYellowCake(String cakemix) {
		super(cakemix);
	}
	
	@Override
	public String getLiquid() {
		return "1 cup tap water";
	}
	
	@Override
	public String getOil() {
		return "1/3 cup vegtable oil";
	}
	
	@Override
	public String getEggs() {
		return "3 large eggs";
	}
}
