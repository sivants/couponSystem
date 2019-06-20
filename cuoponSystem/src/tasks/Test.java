package tasks;

import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;
import facade.AdminFacade;
import facade.ClientFacade;
import facade.ClientType;
import facade.CompanyFacade;
import facade.CustomerFacade;

public class Test {
	
	private CouponExpirationDailyJob job;
	private LoginManager loginManager;
	private AdminFacade adminFacade;
	private CompanyFacade companyFacade;
	private ClientFacade clientFacade;
	private CustomerFacade customerFacade;
	private ClientType loggedAs;

	public void testAll() throws CouponSystemException{
		job = new CouponExpirationDailyJob();
		job.run();
		
		loginManager = LoginManager.getInstance(); 
		loggedAs = ClientType.ADMINISTRATOR;
		Company company = new Company();
		Company company1 = new Company();
		Customer customer = new Customer();
		Customer customer1 = new Customer();
		try {
			adminFacade = (AdminFacade) loginManager.login("admin@admin.com", "admin", loggedAs);
			adminFacade.addCompany(company);
			System.out.println("adding company succeded");
			adminFacade.addCustomer(customer);
			adminFacade.getAllCompanies();
			adminFacade.getAllCustomers();
			adminFacade.getOneCompany(10);
			//adminFacade.getOnecustomer(customerId);
			adminFacade.login("admin@admin.com", "admin");
			adminFacade.updateCompany(company1);
			adminFacade.updateCustomer(customer1);
			 //put an existing companyId:
			adminFacade.deleteCompany(111);
			//adminFacade.deleteCustomer(customerId);
			System.out.println("testing admin succeded");
		} catch (CouponSystemException e) {
			throw new CouponSystemException("Anable to login"); 
		}
	}
}
