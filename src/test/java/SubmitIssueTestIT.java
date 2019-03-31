
import base.Base;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.SubmitIssue;


import java.io.IOException;


public class SubmitIssueTestIT {
    public SubmitIssue s;
    private WebDriverWait wait;

    Base base;
//    WebDriver d;

    SubmitIssueTestIT() throws IOException {

    }

    @BeforeTest
    public void setup() throws IOException {
        base = new Base();
    }
    @BeforeMethod
    public void setupMethod() throws IOException {
        base.ChromeInit();
        s = new SubmitIssue(base.d);

    }

    //    @Test
//    public void validValuesForTheAPI_C1() throws InterruptedException {
//        Assert.assertTrue(s.validValuesForTheAPI_C1());
//    }
//
//    @Test
//    public void nonValidTitle_C2()  {
//        Assert.assertTrue(s.nonValidTitle_C2());
//    }
//
//    @Test
//    public void nothingIsEnteredToBested_C3() throws InterruptedException {
//        Assert.assertTrue(s.nothingIsEntered_C3());
//    }
//
//    @Test
//    public void mandatoryFieldsAreEnteredExceptTitle_C4() throws InterruptedException {
//        Assert.assertTrue(s.mandatoryFieldsAreEnteredExceptTitle_C4());
//    }
//    @Test
//    public void titleIsProvidedButNoTextField_C5() throws InterruptedException {
//
//        Assert.assertTrue(s.titleIsProvidedButNoTextField_C5());
//    }
//    @Test
//    public void noTextisEntered_C6() throws InterruptedException {
//        Assert.assertTrue(s.noTextisEntered_C6());
//    }
//    @Test
//    public void firstTwoButNotThird_C7() throws InterruptedException {
//
//        Assert.assertTrue(s.firstTwoButNotThird_C7());
//    }
//    @Test
//    public void firstIsTwoChars_C9() throws InterruptedException {
//
//        Assert.assertTrue(s.firstIsTwoChars_C9());
//    }
//    @Test
//    public void secondIsTwoChars_C10() throws InterruptedException {
//
//        Assert.assertTrue(s.secondIsTwoChars_C10());
//    }
////
//    @Test
//    public void thirdIsTwoChars_C11() throws InterruptedException {
//        Assert.assertTrue(s.thirdIsTwoChars_C11());
//    }
//    @Test
//    public void FourEntered_C12() throws InterruptedException {
//
//        Assert.assertTrue(s.FourEntered_C12());
//    }
//    @Test
//    public void allFiveEntered_C14() throws InterruptedException, IOException {
//        Assert.assertTrue(s.allFiveEntered_C14());
//
//    }
//    @Test
//    public void title256Chars_C15() throws InterruptedException, IOException {
//        Assert.assertTrue(s.title256Chars_C15());
//    }
//    @Test
//    public void text3001Chars_C16() throws InterruptedException, IOException {
//
//        Assert.assertTrue(s.text3001Chars_C16());
//    }
//    @Test
//    public void text3000Chars_C17() throws InterruptedException, IOException {
//
//        Assert.assertTrue(s.text3000Chars_C17());
//    }
//    @Test
//    public void title255Chars_C18() throws InterruptedException, IOException {
//
//        Assert.assertTrue(s.title255Chars_C18());
//    }
    @Test
    public void createdBy256Chars_C20() throws InterruptedException, IOException {

        Assert.assertTrue(s.createdBy256Chars_C20());
    }
    @Test
    public void createdBy255Chars_C21() throws InterruptedException, IOException {

        Assert.assertTrue(s.createdBy255Chars_C21());
    }
    //
    @AfterMethod
    public void tearDown(){
        base.d.quit();

    }
    @AfterTest
    public void tearDownAll(){
        base=null;

    }
}
