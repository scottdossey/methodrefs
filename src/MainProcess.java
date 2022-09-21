import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

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
	
	public static double process2(BiFunction<Double, Double, Double> operation) {
		double[] x = {1,2,3,4,5,6,7,8};
		double[] y = {2,3,4,5,7,8,9,19};
		
		double sum = 0.0;
		for(int i=0; i< x.length; ++i) {
			sum += operation.apply(x[i], y[i]);
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
		
		//TYPE 1--- Reference to a static method.
		//FORMAT:  ContaininigClass::staticMethodName
		//Example   MainProcess::divide
		System.out.println(process(MainProcess::divide));
		
		
		//TYPE 2--- Reference to an instance method
		//FORMAT: containingObject::instanceMethodName
		//Example:  object::add
		MainProcess object = new MainProcess();
		System.out.println(process(object::add));

		//Type 3 -- Is probably the rarest type.
		//when you call an instance method on a class
		//its kind of like calling a normal function, with a secret hidden
		//parameter of "this"
		
		//Reference to an instance method of an arbitrary object
		//of a particular type:
		//Format is ContainingClass::instanceMethodName
		
		//Sometime you want to call an instance method---
	    String myString="hello";
	    myString.compareTo("hi");  // <0 if hello comes before hi.
	                               // 0 if hello == hi
	                               // >0 if hello comes after hi
		//There is a function interface in java called Comparator....
	    //Comparator<String> is a functional interface
	    //that requires the function:
	
		
	    Comparator<String> myComparable = String::compareTo;
	    myComparable.compare("hello", "hi"); 
	    //The above line does  thje same thing as:
	    "hello".compareTo("hi");
	           
	    
		//Type 4 -- Reference to a constructor
		//Format: ContainingClass::new
		MainProcess value = constructFromInt(MainProcess::new);
		System.out.println(value);
		
		
		//It is really that we can do method references.
		//They do have some downsides though:
		//1. We still need to have an interface definition, which is
		//  a lot of extra code.
		//2. A method reference is great, but often you just want to
		//  define a function real quickly and use it.and for that we 
		//  need something else..
		
		//The thing that we are going to teach right now is that Java
		//has something lambda expressions.
		//Essentially lambda expressions are Java's way of making arrow
		//functions, and the syntax is ALMOST the same.
		//MathOperation variable = (a, b) -> a*b;
		System.out.println(process((a,b) -> {return a+b;}));
		System.out.println("Done");
		
		Integer[] numbers = {6, 1, 7, 5, 3, 0, 9};
		Arrays.sort(numbers, (a, b) -> b-a);
		for(int i=0; i<numbers.length; ++i) {
			System.out.println(numbers[i]);
		}
		
		
		//There is one real big annoyance we still have with using lambda 
		//functions, and that is that we STILL have to define those functional 
		//interface specification.
		
		//But that's a fact of life with Java...there is one trick you can
		//use to make your life a little easier....and that is there is a
		//package in java called java.util.function
		System.out.println(process2((a,b) -> a*b));
		
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
