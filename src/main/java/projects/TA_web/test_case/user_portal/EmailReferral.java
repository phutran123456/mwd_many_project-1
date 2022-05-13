package projects.TA_web.test_case.user_portal;

import SSO_project.data_test.DataTestSSO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.ILoginAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.LoginAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.user_portal.LoginOn23ServerPO;
import projects.TA_web.page_object.user_portal.ReferAndEarnPO;
import projects.TA_web.page_object.user_portal.UserPortalPO;
import projects.TA_web.action.IInputEmailAction;
import projects.TA_web.action.implement_action.InputEmailAction;
import SSO_project.data_test.DataTestSSO;
public class EmailReferral extends BaseTest {
    /**
     * Test case 1: Verify field Email on Referral Page
     *
     *
     *
     *
     * */
    @Test(priority = 1,enabled = true,dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToFieldEmail",
            testName = "Verify field Email on Referral Page",
            description = "Verify field Email on Referral Page successfully"
    )
    public void TC_1_Verify_Email_on_Referral_Page(String textEmail, String errorMessage) {
        System.out.println("Test case 1: Verify field Email on Referral Page successfully");
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        DataTestSSO dataTestSSO = new DataTestSSO();
        IGeneralAction generalAction = new GeneralAction();
        IInputEmailAction inputEmailAction = new InputEmailAction();
        ReferAndEarnPO referAndEarn = new ReferAndEarnPO(Constant.webDriver);


            System.out.println("Test case 01: Verify the UI items on the page 'Edit Profile'");
            LogReport.logMainStep("1. Navigate to URL: https://portal.int.testarchitect.com/");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid user account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_admin_23_Server);
            LogReport.logMainStep("3. Go to the page 'Refer-earn Page'");
            userPortalPO.svgIconReferAndEarn.click();

        try {
            inputEmailAction.InputFields(referAndEarn, textEmail);
            if (!errorMessage.equals("")) {
                generalAction.verifyTextDisplay(errorMessage, referAndEarn.ErrorEmail, false);
            }
            else
            {
                generalAction.verifyTextDisplay(textEmail,referAndEarn.Email,true);}
        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }

    }

}
