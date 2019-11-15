package prob1;

public class HighAltitudeClassicYellowCake extends ClassicYellowCake {

	public HighAltitudeClassicYellowCake(String cakemix) {
		super(cakemix);
	}
	
	@Override
	public String getCakeMix() {
		return super.getCakeMix() + " + 2 tbs flour";
	}
	
	@Override
	public String bake() {
		return"bake at 375 degrees F for 26 minutes";
	}
}
