package stepImplementation;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Step;
import pageElement.LogInPage;

public class LogInImpl extends LogInPage {

	@Step
	public void openUrl() {
		openPageURL();
	}

	@Step
	public Map<String, String> logInWithUser(Map<String, String> devoteeData, String testCaseID1, DataTable dataTable) {
		boolean shouldSignInClick = true;
		devoteeData = getDataTableValuesIntoHashMap(devoteeData, dataTable);
		devoteeData.put("testCaseID", testCaseID);
		testCaseID = testCaseID1;
		TestData = getTestData(TESTDATA, getModuleSheetName(devoteeData.get("moduleName")), testCaseID);

		devoteeData.put("userName", TestData.get("userName"));
		devoteeData.put("password", TestData.get("password"));

		openUrl();
		String scenario = devoteeData.get("scenario").toLowerCase();

		switch (scenario) {
		case "valid_credentials":
		case "incorrect_username":
		case "incorrect_password":
			enterUserName(devoteeData.get("userName"));
			enterPassword(devoteeData.get("password"));
			break;
		case "double_login":
			enterUserName(devoteeData.get("userName"));
			enterPassword(devoteeData.get("password"));
			clickSignIn();
			chkSignInClickable();
			shouldSignInClick = false;
			break;
		case "blank_username_and_password":
			break;
		case "blank_username":
			enterPassword(devoteeData.get("password"));
			break;
		case "blank_password":
			enterUserName(devoteeData.get("userName"));
			break;
		case "reset_password":
			shouldSignInClick = false;
			clickResetPassword();
			break;
		case "wrong_attempts":
			atteptWrongCredentialsLogin(devoteeData);
			shouldSignInClick = false;
			break;
		default:
			enterUserName(devoteeData.get("userName"));
			enterPassword(devoteeData.get("password"));
		}
		if (shouldSignInClick)
			clickSignIn();
		return devoteeData;
	}

	@Step
	protected void validateScenario(Map<String, String> devoteeData, String result, String outcome) {
		String scenario = devoteeData.get("scenario").toLowerCase();
		String uiErrMessage = "";
		switch (scenario) {
		case "valid_credentials":
			validateTitle("accountPage");
			validateLoginSuccess();
			devoteeData.put("isLoginSuccess", "Y");
			logout();
			break;
		case "blank_username":
		case "incorrect_username":
			uiErrMessage = getUserNameErr();
			validateErrorMessage(uiErrMessage, scenario);
			break;
		case "blank_password":
		case "incorrect_password":
			uiErrMessage = getPasswordErr();
			validateErrorMessage(uiErrMessage, scenario);
			break;
		case "blank_username_and_password":
			uiErrMessage = getUserNameErr();
			scenario = "blank_password";
			validateErrorMessage(uiErrMessage, scenario);
			scenario = "blank_username";
			uiErrMessage = getPasswordErr();
			break;
		case "double_login":
			logout();
			break;
		case "reset_password":
			chkResetPasswordPage();
			validateTitle("resetPassword");
			break;
		case "wrong_attempts":
			uiErrMessage = getWrongAttemptErr();
			break;
		default:

		}

	}

	private void validateTitle(String string) {
		// TODO Auto-generated method stub

	}

	private void atteptWrongCredentialsLogin(Map<String, String> devoteeData) {
		for (int i = 0; i < Integer.parseInt(devoteeData.get("noOfAttempts")); i++) {
			enterUserName(devoteeData.get("userName"));
			enterPassword(devoteeData.get("password"));
			clickSignIn();
		}
	}

}
