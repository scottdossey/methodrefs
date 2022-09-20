
//This is a functional interface!
//If only one method is not implemented a Java interface is 
//considered to be "functional"
public interface MathOperation {
	public double calculate(double p1, double p2);
	
	default public double doWhatever() {
		System.out.println("Hi");
		return 7.7;
	}
}
