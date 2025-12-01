package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement email;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryDropDown;
	
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement stateDropDown;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCode;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;

	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement stateProvince;
	
	@FindBy(id = "ShipToSameAddress")
	WebElement shipToSameAddressCheckBox;
	
	@FindBy(id = "shippingoption_0")
	WebElement ground_ShippingMethod;
	
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[2]")
	WebElement billingAddress_ContinueBtn;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement shippingMethod_ContinueBtn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement cash_Payment;
	
	@FindBy(id = "paymentmethod_1")
	WebElement creditCard_Payment;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement paymentMethod_ContinueBtn;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement paymentInfo_ContinueBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement shippingAddress_ContinueBtn;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
	WebElement confirmOrder_ContinueBtn;
	
	@FindBy(css = "h1")
	public WebElement thankYouMessage;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;

	@FindBy(css = "div.title")
	WebElement successMessage;

	@FindBy(css = "div.details-link")
	WebElement click_here_for_order_details_Link;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div/div[3]/button")
	WebElement last_ContinueBtn;
	
	public void registeredUserCheckOutProccess(String countryName, String state, String city, String address, String zipCode, String phoneNumber, String productName) throws InterruptedException {
		
//		clickBtn(shipToSameAddressCheckBox);
		select = new Select(countryDropDown);
		select.selectByVisibleText(countryName);
		select = new Select(stateDropDown);
		select.selectByVisibleText(state);
		textBoxSetText(this.city, city);
		textBoxSetText(this.address, address);
		textBoxSetText(this.zipCode, zipCode);
		textBoxSetText(this.phoneNumber, phoneNumber);
		clickBtn(billingAddress_ContinueBtn);
//		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		explicitWait.until(ExpectedConditions.elementToBeClickable(ground_ShippingMethod));
		Thread.sleep(1000);
		clickBtn(ground_ShippingMethod);
		clickBtn(shippingMethod_ContinueBtn);
//      explicitWait.until(ExpectedConditions.elementToBeClickable(cash_Payment));
		Thread.sleep(1000);
		clickBtn(cash_Payment);
		clickBtn(paymentMethod_ContinueBtn);
		clickBtn(paymentInfo_ContinueBtn);
		}
	
	public void confirmOrder() throws InterruptedException {
	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(1000);
		//clickBtn(shippingAddress_ContinueBtn);
		clickBtn(confirmOrder_ContinueBtn);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
	}
	
	

	
	


	

}
