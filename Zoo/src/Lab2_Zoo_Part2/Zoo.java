package Lab2_Zoo_Part2;

import java.util.ArrayList;

public class Zoo {
	private String location;
	private int numCompounds;
	private int zooID;
	public static int numZoos;
	private ArrayList<Compound> compounds;

	public Zoo() {
		this("Unknown",30);
	}
	
	public Zoo(String location,int numCompounds) {
		this.setLocation(location);
		this.setCompounds(numCompounds);
		compounds=new ArrayList<Compound>();
		numZoos++;
		setZooID(numZoos);
		for(int i=0;i<numCompounds;i++) {
			addCompound(new Compound());
		}
	}

	private void addCompound(Compound compound) {
		this.compounds.add(compound);
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumCompounds() {
		return numCompounds;
	}

	public void setCompounds(int numCompounds) {
		this.numCompounds = numCompounds;
	}
	
	public void buildNewCompound() {
		this.numCompounds++;
	}
	
	public String printInfo() {
		return "ID:"+this.getZooID()+"; location:"+this.getLocation()+"; numCompounds:"+this.getNumCompounds();
	}

	public int getZooID() {
		return zooID;
	}

	private void setZooID(int zooID) {
		this.zooID = zooID;
	}


}
