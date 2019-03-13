package PT2018.assigment1.Assigment_1;

import static org.junit.Assert.*;

import model.*;

public class Test {

	@org.junit.Test
	public void test()
	{
		testAdd();
		testSub();
		testMult();
		testDif();
		testInt();
	}
	
	public void testAdd() {
		Polynomial firstPol = new Polynomial(), secondPol = new Polynomial(), result = new Polynomial(), testRes = new Polynomial();
		firstPol.getPolynomial().add(new IntMonomial(3, 3));
		firstPol.getPolynomial().add(new IntMonomial(2, 2));
		firstPol.getPolynomial().add(new IntMonomial(1, 1));
		firstPol.getPolynomial().add(new IntMonomial(0, 0));
		
		secondPol.getPolynomial().add(new IntMonomial(1, 2));
		secondPol.getPolynomial().add(new IntMonomial(1, 1));
		secondPol.getPolynomial().add(new IntMonomial(1, 0));

		result.getPolynomial().add(new IntMonomial(3, 3));
		result.getPolynomial().add(new IntMonomial(3, 2));
		result.getPolynomial().add(new IntMonomial(2, 1));
		result.getPolynomial().add(new IntMonomial(1, 0));
		
		testRes = firstPol.addition(secondPol);

		assertEquals(result.toString(result), testRes.toString(testRes));
	}
	
	public void testSub()
	{
		Polynomial firstPol = new Polynomial(), secondPol = new Polynomial(), result = new Polynomial(), testRes = new Polynomial();

		firstPol.getPolynomial().add(new IntMonomial(3, 3));
		firstPol.getPolynomial().add(new IntMonomial(2, 2));
		firstPol.getPolynomial().add(new IntMonomial(1, 1));
		firstPol.getPolynomial().add(new IntMonomial(0, 0));
		
		secondPol.getPolynomial().add(new IntMonomial(1, 2));
		secondPol.getPolynomial().add(new IntMonomial(1, 1));
		secondPol.getPolynomial().add(new IntMonomial(1, 0));
		
		result = new Polynomial();
		
		result.getPolynomial().add(new IntMonomial(3, 3));
		result.getPolynomial().add(new IntMonomial(1, 2));
		result.getPolynomial().add(new IntMonomial(0, 1));
		result.getPolynomial().add(new IntMonomial(-1, 0));
		
		testRes = firstPol.subtraction(secondPol);
		
		assertEquals(result.toString(result), testRes.toString(testRes));
	}
	
	public void testMult()
	{
		Polynomial firstPol = new Polynomial(), secondPol = new Polynomial(), result = new Polynomial(), testRes = new Polynomial();

		firstPol.getPolynomial().add(new IntMonomial(3, 3));
		firstPol.getPolynomial().add(new IntMonomial(2, 2));
		firstPol.getPolynomial().add(new IntMonomial(1, 1));
		firstPol.getPolynomial().add(new IntMonomial(0, 0));
		
		secondPol.getPolynomial().add(new IntMonomial(1, 2));
		secondPol.getPolynomial().add(new IntMonomial(1, 1));
		secondPol.getPolynomial().add(new IntMonomial(1, 0));
		
		result = new Polynomial();
		
		result.getPolynomial().add(new IntMonomial(3, 5));
		result.getPolynomial().add(new IntMonomial(5, 4));
		result.getPolynomial().add(new IntMonomial(6, 3));
		result.getPolynomial().add(new IntMonomial(3, 2));
		result.getPolynomial().add(new IntMonomial(1, 1));
		result.getPolynomial().add(new IntMonomial(0, 0));

		
		testRes = firstPol.multiplication(secondPol);
		System.out.println(result.toString(result));
		System.out.println(testRes.toString(testRes));

		assertEquals(result.toString(result), testRes.toString(testRes));
	}
	
	public void testDif()
	{
		Polynomial firstPol = new Polynomial(), result = new Polynomial(), testRes = new Polynomial();

		firstPol.getPolynomial().add(new IntMonomial(3, 3));
		firstPol.getPolynomial().add(new IntMonomial(2, 2));
		firstPol.getPolynomial().add(new IntMonomial(1, 1));
		firstPol.getPolynomial().add(new IntMonomial(0, 0));
		
		result = new Polynomial();
		
		result.getPolynomial().add(new IntMonomial(9, 2));
		result.getPolynomial().add(new IntMonomial(4, 1));
		result.getPolynomial().add(new IntMonomial(1, 0));
		
		testRes = firstPol.differentiation();
		
		assertEquals(result.toString(result), testRes.toString(testRes));
	}
	
	public void testInt()
	{
		Polynomial firstPol = new Polynomial(), result = new Polynomial(), testRes = new Polynomial();

		firstPol.getPolynomial().add(new IntMonomial(3, 3));
		firstPol.getPolynomial().add(new IntMonomial(2, 2));
		firstPol.getPolynomial().add(new IntMonomial(1, 1));
		firstPol.getPolynomial().add(new IntMonomial(0, 0));
		
		result = new Polynomial();
		
		result.getPolynomial().add(new RealMonomial(0.75, 4));
		result.getPolynomial().add(new RealMonomial(0.67, 3));
		result.getPolynomial().add(new RealMonomial(0.5, 2));
		result.getPolynomial().add(new RealMonomial(0.0, 1));
		result.getPolynomial().add(new RealMonomial(0.0, 0));
		
		testRes = firstPol.integration();
		
		assertEquals(result.toString(result), testRes.toString(testRes));
	}
	

}
