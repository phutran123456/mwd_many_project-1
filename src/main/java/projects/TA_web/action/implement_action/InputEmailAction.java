package projects.TA_web.action.implement_action;
import common.Constant;
import common.SSOUtilImpA;
import general_action.implement.GeneralAction;
import general_action.IGeneralAction;
import projects.TA_web.page_object.user_portal.ReferAndEarnPO;
import projects.TA_web.action.IInputEmailAction;

public class InputEmailAction implements IInputEmailAction {
    @Override
    public void InputFields(ReferAndEarnPO referAndEarnPO, String textInput) throws InterruptedException {
        SSOUtilImpA ssoUtilImpA = new SSOUtilImpA();
        ssoUtilImpA.setThreadSleep(3000);
        IGeneralAction generalAction = new GeneralAction();
        IInputEmailAction inputEmailAction = new InputEmailAction();
        ReferAndEarnPO referAndEarn = new ReferAndEarnPO(Constant.webDriver);
        referAndEarnPO.Email.clear();
        referAndEarnPO.Email.sendKeys(textInput);
        referAndEarnPO.btnSend.click();


    }

}
