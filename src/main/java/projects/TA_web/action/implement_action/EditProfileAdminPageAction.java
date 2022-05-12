package projects.TA_web.action.implement_action;

import common.Constant;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.IEditProfileAction;
import projects.TA_web.page_object.admin_portal.EditProfileAdminPagePO;
import projects.TA_web.page_object.user_portal.EditProfilePO;

public class EditProfileAdminPageAction implements IEditProfileAction {
    @Override
    public void UploadAvatar(EditProfilePO editProfilePO, boolean isImage) throws InterruptedException {

    }

    @Override
    public void UpdateFields(EditProfilePO editProfilePO, String textInput) throws InterruptedException {
        SSOUtilImpA ssoUtilImpA = new SSOUtilImpA();
        ssoUtilImpA.setThreadSleep(3000);
        editProfilePO.inputFirstName.clear();
        editProfilePO.inputFirstName.sendKeys(textInput);
        editProfilePO.inputLastName.clear();
        editProfilePO.inputLastName.sendKeys(textInput);
        editProfilePO.labelCompany.click();

    }

    @Override
    public void checkAllFieldsDisplayed(IGeneralAction generalAction, EditProfilePO editProfilePO) {
        generalAction.verifyElementDisplayed(editProfilePO.labelFirstName,"Label first name ");
        generalAction.verifyElementDisplayed(editProfilePO.labelLastName,"Label last name");
        generalAction.verifyElementDisplayed(editProfilePO.inputFirstName,"input field first name");
        generalAction.verifyElementDisplayed(editProfilePO.inputLastName,"input field last name");
        generalAction.verifyElementDisplayed(editProfilePO.labelCompany,"label company");
        generalAction.verifyElementDisplayed(editProfilePO.inputComany,"input field company");
        generalAction.verifyElementDisplayed(editProfilePO.labelState,"label state");
        generalAction.verifyElementDisplayed(editProfilePO.inputState,"input state");
        generalAction.verifyElementDisplayed(editProfilePO.labelTitle,"label title");
        generalAction.verifyElementDisplayed(editProfilePO.inputTitle,"input title");
        generalAction.verifyElementDisplayed(editProfilePO.labelPhone,"label phone");
        generalAction.verifyElementDisplayed(editProfilePO.inputPhone,"input field phone");
        generalAction.verifyElementDisplayed(editProfilePO.btnSave,"button Save");
        generalAction.verifyElementDisplayed(editProfilePO.btnCancelEditProfile,"button Cancel");

    }

    @Override
    public void checkAllErrorMsg(IGeneralAction generalAction, WebDriver webDriver, EditProfilePO editProfilePO) {

    }

    @Override
    public void inputEmailToEdit(String email,EditProfileAdminPagePO editProfileAdminPagePO) throws InterruptedException {
        SSOUtilImpA ssoUtilImpA = new SSOUtilImpA();
        ssoUtilImpA.setThreadSleep(5000);
        editProfileAdminPagePO.inputSearch.click();
        editProfileAdminPagePO.inputSearch.sendKeys(email);
        editProfileAdminPagePO.btnSearch.click();
        ssoUtilImpA.setThreadSleep(5000);
        editProfileAdminPagePO.emailValue.click();
        ssoUtilImpA.setThreadSleep(5000);
        editProfileAdminPagePO.btnEdit.click();


    }
}
