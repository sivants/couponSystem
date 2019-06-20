package facade;

import DAOclasses.CouponsDbDAO;
import beans.Category;
import beans.Coupon;
import exceptions.CouponSystemException;
import tasks.LoginManager;

public class FacadeTest2 {
	public static void main(String[] args) {
	
		LoginManager log = LoginManager.getInstance();
		try {
			//AdminFacade af = (AdminFacade) log.login("admin@admin", "admin", ClientType.ADMINISTRATOR);
			
			CompanyFacade comFacade = (CompanyFacade) log.login("email2", "222", ClientType.COMPANY);
			
			Coupon coupon = new Coupon();
			coupon.setCompanyId(14);
			coupon.setAmount(20);
			coupon.setCategory(Category.ELECTRICITY);
			coupon.setCategoryId(1);
			coupon.setDescription("blabla");
			coupon.setEndDate(null);
			coupon.setStartDate(null);
			coupon.setImage("blabla");
			coupon.setTittle("couponTest");
			coupon.setPrice(140);
			
			CouponsDbDAO couponsDAO = new CouponsDbDAO();
			System.out.println(comFacade.getCompanyCoupons(14));
			comFacade.addCoupon(coupon);
			System.out.println(couponsDAO.getOneCoupon(coupon.getId()));
			System.out.println(comFacade.getCompanyCoupons(Category.FOOD));
			System.out.println(comFacade.getCompanyCoupons(50.9));
			System.out.println(comFacade.getCompanyCoupons(14));
			System.out.println(comFacade.getCompanyDetails(14));
			
			coupon.setAmount(35);
			coupon.setPrice(30);
			System.out.println(couponsDAO.getOneCoupon(coupon.getId()));
			comFacade.updateCoupon(coupon);
			System.out.println(couponsDAO.getOneCoupon(coupon.getId()));
			comFacade.deleteCoupon(coupon.getId());
			//System.out.println(couponsDAO.getOneCoupon(couponId));
			
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}
	}
}
