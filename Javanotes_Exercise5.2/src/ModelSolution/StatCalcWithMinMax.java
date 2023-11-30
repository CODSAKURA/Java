package ModelSolution;

public class StatCalcWithMinMax extends StatCalc {

	   private double max = Double.NEGATIVE_INFINITY;  // Largest item seen.
	   private double min = Double.POSITIVE_INFINITY;  // Smallest item seen.

	   public void enter(double num) {
	      super.enter(num);  // Call the enter method from the StatCalc class.
	      if (num > max)  // Then do the extra processing for min and max.
	         max = num;
	      if (num < min)
	         min = num;
	   }
	 
	   public double getMin() {
	      return min;
	   }
	   
	   public double getMax() {
	      return max;
	   }

	}  // end class StatCalcWithMinMax