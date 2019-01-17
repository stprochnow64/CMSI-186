public class Riemann{

public Riemann(double lowBound, double upBound, double[] polynomial){

		System.out.println(riemmanSum(lowBound, upBound, polynomial));

	}

	public static double riemannSum(double lowBound, double upBound, double[] polynomial){

		double lastArea = 0;
		double slice = 2;
		double area = (upBound - lowBound) * (polynomialResult((upBound + lowBound) / 2, polynomial));

		while (Math.abs(lastArea - area) > .01) {

			double sliceWidth =  Math.abs((upBound - lowBound) / slice);
			double newLowBound = lowBound;
		  double newUpBound = lowBound + sliceWidth;
			lastArea = area;
			area = 0;

			for(int i = (int) slice; i > 0; i-- ) {

				area += ((newUpBound - newLowBound) * (polynomialResult((newUpBound + newLowBound) / 2, polynomial)));

				newLowBound += sliceWidth;
				newUpBound += sliceWidth;

			}
			slice = Math.pow(slice, 2.0);
		}
		return area;
	}

	public static double polynomialResult(double x, double[] polynomial){

		double sum = 0;

		for(int i = 0; i < polynomial.length; i++){
			sum += polynomial[i] * Math.pow(x, i);
		}
		return sum;
	}

	public static void main(String[] args){

		double lowerBound = Double.parseDouble(args[args.length - 2]);
		double upperBound = Double.parseDouble(args[args.length - 1]);
		double[] polynomial = new double[args.length - 2];
		for(int i = 0; i <= args.length  - 3; i++){
				polynomial[i] = Double.parseDouble(args[i]);
		}
			Riemann ri = new Riemann(lowerBound, upperBound, polynomial);
		}

}
