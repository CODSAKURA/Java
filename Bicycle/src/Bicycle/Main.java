package Bicycle;

public class Main {

    public static void main(String[] args){
    	Mountainbike bike1=new Mountainbike(7,true,true);
        Mountainbike bike2=new Mountainbike(7,false,true);
        bike1.currentState();
        bike2.currentState();
        System.out.println();       
        bike1.switchLightStatus();
        bike1.speedUp(5);
        bike1.currentState();
        bike2.currentState();
        System.out.println();
        System.out.println(bike1.getClass().getSimpleName()+"; isFullSuspension:"+bike1.isFullSuspension());
        System.out.println(bike2.getClass().getSimpleName()+"; isFullSuspension:"+bike2.isFullSuspension());
    
    }
}
