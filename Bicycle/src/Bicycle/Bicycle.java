package Bicycle;

public class Bicycle {
        private int gear;
        private int speed;
        private boolean lightstatus;
        
        
        public Bicycle(int gear) 
        {
        	speed = 0;
        	this.gear = gear;
        	this.lightstatus=false;
        }
               
                
        public void setGear(int newValue) {
            gear=newValue;
        }

        public void applyBrake(int decrement) {
        	speed = speed - decrement;
        }

        public void speedUp(int increment) {
            speed = speed + increment;
        }

        public void switchLightStatus()
        {
            if(lightstatus)
            {
                lightstatus=false;
            }
            else
            {
                lightstatus=true;
            }
        }

        public void currentState()
        {
            System.out.println("Gear:" + gear + "; Speed:" + speed + "; LightStatus:" + lightstatus);
        }
        
    }
