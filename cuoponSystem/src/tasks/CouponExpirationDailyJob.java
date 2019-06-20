package tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import DAOclasses.CouponsDAO;
import beans.Coupon;
import exceptions.CouponSystemException;

public class CouponExpirationDailyJob implements Runnable {

	private boolean quit = false;
	private CouponsDAO couponsDAO;
	
	public CouponExpirationDailyJob() {
	}

	public CouponExpirationDailyJob(boolean quit, CouponsDAO couponDAO) {
		super();
		this.quit = quit;
		this.couponsDAO = couponDAO;
	}

	@Override
	public void run() {
		while (!quit) {
			Collection<Coupon> allCoupons = new ArrayList<Coupon>();
			for (Coupon currCoupon : allCoupons) {
				if (currCoupon.getEndDate().before(new Date()));{
					try {
						couponsDAO.deleteCoupon(currCoupon.getId());
					} catch (CouponSystemException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

	public void stop() {
		quit = true;
		Thread.currentThread().interrupt();
	}
}
