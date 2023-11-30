package Bicycle;

public class MountainBike extends Bicycle {
    
    // the MountainBike subclass has
    // one field
    public int seatHeight;

    // the MountainBike subclass has
    // one constructor
    public MountainBike(int startHeight, int startCadence,int startSpeed, int startGear) 
    {
        
    	super(startCadence, startSpeed, startGear);
        seatHeight = startHeight; 
        //因为前面三个parameter那个Bicycle class有所以要super一遍为了初始化
        //后面新加了一个seatHeight所以要表示一下
    }   
        
    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) 
    {
        seatHeight = newValue;
    }   

}
