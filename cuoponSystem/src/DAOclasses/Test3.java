package DAOclasses;

import beans.Customer;
import exceptions.CouponSystemException;

public class Test3 {
public static void main(String[] args) {
	
	Customer customer = new Customer();
	customer.setFirstName("David");
	customer.setLastName("Hes");
	customer.setEmail("email7");
	customer.setPassword("777");
	CustomersDAO dao = new CustomersDbDAO();
	CouponsDAO dao1 = new CouponsDbDAO();
	try {
		int customerId = dao.addCustomer(customer); 
		System.out.println(dao.getOneCustomer(customerId));
		//dao1.addCouponPurchase(2, 102);
		dao1.addCouponPurchase(customerId, 103);
		dao1.deleteCouponPurchase(customerId, 102);
	} catch (CouponSystemException e) {
		e.printStackTrace();
	}
}
}
