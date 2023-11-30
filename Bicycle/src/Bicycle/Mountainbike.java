package Bicycle;

public class Mountainbike extends Bicycle {
    private boolean suspensionFront;
    private boolean suspensionRear;

    public Mountainbike(int gear, boolean suspensionFront, boolean suspensionRear) {
        super(gear);
        this.suspensionFront=suspensionFront;
        this.suspensionRear=suspensionRear;
    }

    @Override
    public void currentState(){
    	super.currentState();
        System.out.println("Suspension(Front):"+suspensionFront+"; Suspension(Rear):"+suspensionRear);
    }

    public boolean isFullSuspension(){
        if(suspensionFront&&suspensionRear)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
