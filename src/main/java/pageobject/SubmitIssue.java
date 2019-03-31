package pageobject;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import testdatamanipulation.Data;
import utility.GetWaits;


import java.io.IOException;



public class SubmitIssue  extends Data {
    static final Logger log= LogManager.getLogger("SubmitIssue.class");
    private WebDriver d;
    
    GetWaits getWaits;
    
    public SubmitIssue(WebDriver d) throws IOException {
        super();
        this.d = d;
        PageFactory.initElements(d,this);
        getWaits = new GetWaits();
    }

    @FindBy(css = "form[method='post'] input[name='issue_title']")
    WebElement title;

    @FindBy(css = "form[method='post'] textarea[name='issue_text']")
    WebElement text;

    @FindBy(css = "form[method='post'] input[name='created_by']")
    WebElement createdBy;

    @FindBy(css = "form[method='post'] input[name='assigned_to']")
    WebElement assignedTo;

    @FindBy(css = "form[method='post'] input[name='status_text']")
    WebElement statusText;

    @FindBy(css = "form[method='post'] button[type='submit']")
    WebElement submit;

    @FindBy(id = "jsonResult")
    public WebElement jsonResult;

    public Boolean success(String value){
        pause();
        String jsonText = jsonResult.getText();
        boolean containsSuccess=false;
        if(jsonText.contains(value)){
            containsSuccess=true;
        }
        return containsSuccess;
    }
    public Boolean fail(String value){
        pause();
        String jsonText = jsonResult.getText();
        boolean err=false;
        if(jsonText.contains(value)){
            err=true;
        }

        return err;
    }

    public void sendValidTitle(){
        title.sendKeys(getValidTitle());
    }
    public void sendValidText(){
        text.sendKeys(getValidText());
    }
    public void sendValidCreatedBy(){
        createdBy.sendKeys(getValidCreatedBy());
    }
    public void sendAssignedTo(){
        assignedTo.sendKeys(getAssignedTo());
    }
    public void submit (){
        submit.click();
    }
    public void pause(){
        getWaits.callWait(jsonResult,d);
    }
    public void sendInvalidTitle(){
        title.sendKeys(getInvalidTitle());
    }
    public void sendInvalidText(){
        text.sendKeys(getInvalidText());
    }
    public void sendInvalidCreatedBy(){
        createdBy.sendKeys(getInvalidCreatedBy());
    }
    public void sendStatusText(){
        statusText.sendKeys(getStatusText());
    }

    public Boolean validValuesForTheAPI_C1()  {
        sendValidTitle();
        sendValidText();
        sendValidCreatedBy();
        submit.click();
        pause();
        return success(getSuccess());
    }
    public Boolean nonValidTitle_C2(){
        sendInvalidTitle();
        submit();
        pause();
        return fail(getErrTitle());
    }

    public Boolean nothingIsEntered_C3()  {
        submit();
        pause();
        return fail(getErrTitle());
    }

    public Boolean mandatoryFieldsAreEnteredExceptTitle_C4()  {
        sendValidText();
        sendValidCreatedBy();
        submit();
        pause();
        return fail(getErrTitle());
    }

    public Boolean titleIsProvidedButNoTextField_C5()  {
        sendValidTitle();
        submit();
        pause();
        return fail(getErrText());
    }

    public Boolean noTextisEntered_C6()  {
        sendValidTitle();
        sendValidCreatedBy();
        submit();
        pause();
        return fail(getErrText());
    }
    //
    public Boolean firstTwoButNotThird_C7()  {
        sendValidTitle();
        sendValidText();
        submit();
        pause();
        return  fail(getErrCreatedBy());
    }
    //
    public Boolean firstIsTwoChars_C9()  {
        sendInvalidTitle();
        sendValidText();
        sendValidCreatedBy();
        submit();
        pause();
        return fail(getErrTitle());
    }

    public Boolean secondIsTwoChars_C10()  {
        sendValidTitle();
        sendInvalidText();
        sendValidCreatedBy();
        submit();
        pause();
        return fail(getErrText());
    }
    ////
//
    public Boolean thirdIsTwoChars_C11()  {
        sendValidTitle();
        sendValidText();
        sendInvalidCreatedBy();
        submit();

        return fail(getErrCreatedBy());
    }

    public Boolean FourEntered_C12()  {
        sendValidTitle();
        sendValidText();
        sendValidCreatedBy();
        sendAssignedTo();
        submit();

        return success(getSuccess());
    }
    //
    public Boolean allFiveEntered_C14()  {
        sendValidTitle();
        sendValidText();
        sendValidCreatedBy();
        sendAssignedTo();
        sendStatusText();
        submit();

        return success(getSuccess());
    }

    public Boolean title256Chars_C15() throws IOException {
        String chars256 = createData(256);
        title.sendKeys(chars256);
        sendValidText();
        sendValidCreatedBy();
        sendAssignedTo();
        sendStatusText();
        submit();

        return fail(getErrTitle());
    }

    public Boolean text3001Chars_C16() throws IOException {
        String data = createData(3001);
        sendValidTitle();
        text.sendKeys(data);
        sendValidCreatedBy();
        submit();

        return fail(getErrText());
    }

    public Boolean text3000Chars_C17() throws IOException {
        String data = createData(3000);
        sendValidTitle();
        text.sendKeys(data);
        sendValidCreatedBy();
        submit();
        return success(getSuccess());
    }

    public Boolean title255Chars_C18() throws IOException {
        String chars256 = createData(255);
        title.sendKeys(chars256);
        sendValidText();
        sendValidCreatedBy();
        sendAssignedTo();
        sendStatusText();
        submit();
        return success(getSuccess());
    }

    public Boolean createdBy256Chars_C20() throws IOException {
        String data = createData(256);
        sendValidTitle();
        sendValidText();
        createdBy.sendKeys(data);
        submit();
        return fail(getErrCreatedBy());
    }

    public Boolean createdBy255Chars_C21() throws IOException {
        String data = createData(255);
        log.info(data);
        sendValidTitle();
        sendValidText();
        createdBy.sendKeys(data);
        submit();
        return success(getSuccess());
    }


}
