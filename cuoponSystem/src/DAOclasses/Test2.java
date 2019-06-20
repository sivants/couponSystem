package DAOclasses;

import beans.Category;
import beans.Coupon;
import exceptions.CouponSystemException;

public class Test2 {

	public static void main(String[] args) {
		
		Coupon coupon = new Coupon();
		coupon.setCategoryId(1);
		coupon.setEndDate(null);
		coupon.setStartDate(null);
		coupon.setImage("cImage");
		coupon.setAmount(200);
		coupon.setDescription("");
		coupon.setPrice(12.00);
		coupon.setTittle("ccc");
		coupon.setCompanyId(11);
		coupon.setCategory(Category.ELECTRICITY);
	
	CouponsDAO dao = new CouponsDbDAO();
	try {
		//dao.addCoupon(coupon);
		System.out.println(dao.getOneCoupon(102));
		System.out.println(dao.getAllCoupons());
		dao.deleteCoupon(104);
		System.out.println(dao.getAllCoupons());
		
	} catch (CouponSystemException e) {
		e.printStackTrace();
	}
	
}
}
