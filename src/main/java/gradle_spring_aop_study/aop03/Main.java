package gradle_spring_aop_study.aop03;

import gradle_spring_aop_study.aop01.ImpeCalculator;
import gradle_spring_aop_study.aop01.RecCalculator;

public class Main {

	public static void main(String[] args) {
		int num = 5;
		long res = 0;

		ExeTimeCalculator impeCal = new ExeTimeCalculator(new ImpeCalculator());
		res = impeCal.factorial(num);
		System.out.printf("%d! = %d%n", num, res);
		
		ExeTimeCalculator recCal = new ExeTimeCalculator(new RecCalculator());
		res = recCal.factorial(num);
		System.out.printf("%d! = %d%n", num, res);

	}

}
