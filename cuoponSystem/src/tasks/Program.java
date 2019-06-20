package tasks;

import exceptions.CouponSystemException;

public class Program {
	public static void main(String[] args) throws CouponSystemException {
		Test test = new Test();
		try {
			test.testAll();
		} catch (CouponSystemException e) {
			throw new CouponSystemException("something went wrong");
		}
		
	}

}
