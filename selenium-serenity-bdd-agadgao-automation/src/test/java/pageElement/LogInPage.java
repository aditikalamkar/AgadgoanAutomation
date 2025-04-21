package pageElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import reusableLibrary.CustomLog.LogInfo;

public class LogInPage extends MasterPage {

	// ********* SignIn flow Starts Here ***********//
	@FindBy(xpath = "//input[@id='username-inp']")
	WebElementFacade userNameInput;

	public void enterUserName(String username) {
		enterText(userNameInput, username);
	}

	@FindBy(xpath = "//input[@id='password-inp']")
	WebElementFacade passwordInput;

	public void enterPassword(String password) {
		enterText(passwordInput, password);
	}

	@FindBy(xpath = "//button[@id='signInSubmitButton']")
	WebElementFacade signIn;

	public void clickSignIn() {
		clickOnElement(signIn);
	}

	protected void chkSignInClickable() {
		if (signIn.isClickable())
			LogInfo.WithoutScreenShot("Sign In is multi-clickable and can send multiple login requests ", "Fail");
		else
			LogInfo.WithoutScreenShot("Sign In is not be multi-clickable to avoid multiple login requests ", "Pass");
	}
	// ********* SignIn flow Ends Here ***********//

	// ********* Forgot Password flow Starts Here ***********//
	@FindBy(xpath = "//*[@id='forgotPasswordHref']")
	WebElementFacade forgotPassword;

	public void clickResetPassword() {
		clickOnElement(forgotPassword);
	}

	protected void chkResetPasswordPage() {
		if (forgotPassword.isPresent())
			LogInfo.WithoutScreenShot("Reset Passeword link is present", "Pass");
		else
			LogInfo.WithoutScreenShot("Reset Passeword link is not present", "Fail");
	}

	@FindBy(xpath = "//*[@id='usernameInput']")
	WebElementFacade forgotUserName;

	public void forgotUserName() {
		clickOnElement(forgotUserName);
	}

	@FindBy(xpath = "//*[@id='signInSubmitButton']")
	WebElementFacade signInSubmitButton;

	public void signInSubmitButton() {
		clickOnElement(signInSubmitButton);
	}

	@FindBy(xpath = "//*[@id='cancelHref']")
	WebElementFacade cancelForgotPassword;

	public void cancelForgotPassword() {
		clickOnElement(cancelForgotPassword);
	}

	@FindBy(xpath = "//*[@id='signInHeading']")
	WebElementFacade chkResetAccessTxt;

	public void getResetAccessTxt() {
		chkText(chkResetAccessTxt, "Reset access");

	}

	protected void chkResetPasswordLink() {
		if (chkResetAccessTxt.isPresent())
			LogInfo.WithoutScreenShot("Reset Passeword Page loaded", "Pass");
		else
			LogInfo.WithoutScreenShot("Reset Passeword Page not available", "Fail");
	}

	// ********* Forgot Password flow Starts Here ***********//

	// ********* Error Message Check flow Starts Here ***********//

	protected String getWrongAttemptErr() {

		return null;
	}

	@FindBy(xpath = "//app-validated-input[@name='username']//app-error-message")
	WebElementFacade userNameError;

	public String getUserNameErr() {
		return getElementText(userNameError);
	}

	@FindBy(xpath = "//app-validated-input[@name='password']//app-error-message")
	WebElementFacade getPasswordErr;

	public String getPasswordErr() {
		return getElementText(getPasswordErr);
	}

	@FindBy(xpath = "//*[@data-qa='signin-div-error-display']")
	WebElementFacade getUserNameOrPasswordWrongError;

	public String getUserNameOrPasswordWrongError() {
		return getElementText(getUserNameOrPasswordWrongError);
	}

	// ********* Error Message Check flow ends Here ***********//

	// ********* LogOut flow ends Here ***********//

	@FindBy(xpath = "//*[@name='avatar']")
	WebElementFacade avatar;
	@FindBy(xpath = "//*[@data-qa='toolbar-sign-out']")
	WebElementFacade signOut;

	public void logout() {
		if ("Y".equalsIgnoreCase(devoteeData.get("isLoginSuccess"))) {
			clickOnElement(avatar);
			clickOnElement(signOut);
		}
	}

	// ********* LogOut flow ends Here ***********//

	// ********* Reusable Methods Starts Here ***********//
	protected void validateLoginSuccess() {
		devoteeData.put("isLoginSuccess", "Y");
	}

	// ********* Reusable Methods ends Here ***********//

}