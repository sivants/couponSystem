package facade;


import DAOclasses.CouponsDbDAO;
import DAOclasses.CustomersDbDAO;
import beans.Category;
import beans.Coupon;
import beans.Customer;
import exceptions.CouponSystemException;
import tasks.LoginManager;

public class FacadeTest3 {
	public static void main(String[] args) {
	
			LoginManager logM = LoginManager.getInstance();
			CouponsDbDAO couponDAO = new CouponsDbDAO();
			CustomersDbDAO customerDAO = new CustomersDbDAO();
			
			try {
				Coupon coupon = new Coupon();
				coupon.setAmount(60);
				coupon.setCategory(Category.FOOD);
				coupon.setCompanyId(14);
				coupon.setDescription(null);
				coupon.setEndDate(java.sql.Date.valueOf("2019-12-01"));
				coupon.setStartDate(null);
				coupon.setImage(null);
				coupon.setPrice(12.00);
				coupon.setTittle("1+1 free");
				int couponId = couponDAO.addCoupon(coupon);
				coupon.setId(couponId);
				
				Customer customer = new Customer("Idan", "Cohen", "email9", "999");
				int customerId = customerDAO.addCustomer(customer);
				customer.setId(customerId);
				
				couponDAO.addCouponPurchase(customerId, couponId);
				CustomerFacade cusFacade = (CustomerFacade) logM.login("email9", "999", ClientType.CUSTOMER);
				System.out.println(cusFacade.getCustomerDetails(customerId));
				cusFacade.purchaseCoupon(coupon);
				System.out.println(cusFacade.getCustomerCoupons());
				System.out.println(cusFacade.getCustomerCoupons(Category.FOOD));
				System.out.println(cusFacade.getCustomerCoupons(100));
				
				couponDAO.deleteCouponPurchase(customerId, couponId);
				couponDAO.deleteCoupon(couponId);
				customerDAO.deleteCustomer(customerId);
			} catch (CouponSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
