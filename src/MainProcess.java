
/*
	function multiply(p1, p2) {
	    return p1*p2;
	}
	
	function process(operation) {
	    let x=[1,2,3,4,5,6,7,8]
	    let y=[2,4,5,6,7,8,9,19]
	    
	    let sum=0;
	    for(let i=0; i<x.length; ++i) {
	        sum += operation(x[i], y[i]);
	    }
	    return sum;
	}
	
	
	process(multiply);
*/

public class MainProcess {
	private int x;
	
	MainProcess() {		
	}
	
	MainProcess(int x) {
		this.x = x;
	}
	
	
	public double add(double a, double b) {
		return a+b;
	}
	
	
	public static double process(MathOperation operation) {
		double[] x = {1,2,3,4,5,6,7,8};
		double[] y = {2,3,4,5,7,8,9,19};
		
		double sum = 0.0;
		for(int i=0; i< x.length; ++i) {
			sum += operation.calculate(x[i], y[i]);
		}
		return sum;
 	}
	
	public static MainProcess constructFromInt(CreateObjectFromInt factory) {
		MainProcess value = factory.create(3);
		return value;
	}
	
	
	public static double divide(double a, double b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		MathOperation mathOperation = new MultiplyOperation();
		System.out.println(process(mathOperation));	
	
		//We had to create a class, and then instantiate that class
		//and pass it to effectively pass a method
		
		
		//Since MathOperation is a "functional interface" I can 
		//also pass method references and have them act like
		//a MathOperation....
		
		
		//MathOperation operation = MainProcess::divide;
		//There are actually four different types of method 
		//reference.
		
		//TYPE 1--- Reference to a statis method.
		//FORMAT:  ContaininigClass::staticMethodName
		//Example   MainProcess::divide
		System.out.println(process(MainProcess::divide));
		
		
		//TYPE 2--- Reference to an instance method
		//FORMAT: containingObject::instanceMethodName
		//Example:  object::add
		MainProcess object = new MainProcess();
		System.out.println(process(object::add));

		//Type 3 -- Gonna SKip this till tomorrow.
		
		
		//Type 4 -- Reference to a constructor
		//Format: ContainingClass::new
		MainProcess value = constructFromInt(MainProcess::new);
		System.out.println(value);					
	}
	
	
	//So along came later versions of Java and they wanted to implement
	//some way of passing a method around that wasn't quite so cumbersome.
	
	//They came up with a concept in Java called Method References......
	//But when creating this new way of doing things they decided that they
	//didn't want to reinvent how Java is written and it needed to be backwards
	//compatible with the way Java did things before, and most importantly that 
	//the libraries that we all know and love from Javadoc wouldn't have to be
	//changed in an incompatible way.
	
	//WE ARE STILL GOING TO PASS functions by using INTERFACES....
	//But we are going to define a special kind of INTERFACE called a 
	//"functional interface".
	
	//A "functional interface" is any interface you create in Java that has only 
	//one unimplmented method.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
