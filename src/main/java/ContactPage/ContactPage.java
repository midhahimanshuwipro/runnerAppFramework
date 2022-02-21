package ContactPage;

import Utils.Base;
import Utils.RandomData;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import static ContactPage.ContactPageObjectRepo.*;

public class ContactPage extends Base {

    static RandomData rd = new RandomData();

    public static ContactPageObjectRepo cp;


    public  ContactPage()
    {
        cp= new ContactPageObjectRepo(driver);
    }


    //driver.hideKeyboard();


    public static void verifyIsContactPageDisplayed()
    {
        waitUntilElementIsVisible(cp.addToFavBtn);
    }


    public static boolean clickAddTofavBtn()
    {
        if(cp.addToFavBtn.isEnabled() | cp.addToFavBtn.isDisplayed())
        {
            cp.addToFavBtn.click();
            return true;
        }
        else
            System.out.println("unable to find add to Favourite Btn");
        return false;
    }


    public static boolean clickcreateNewContactBtn() {
        try {
            if (cp.createNewContactBtn.isDisplayed() | cp.createNewContactBtn.isEnabled()) {
                cp.createNewContactBtn.click();
                sleep(2000);

            } else
                createNewContactBtn1.click();
            return true;
        }
        catch (Exception e)
        {
            createNewContactBtn1.click();
        }
        return true;
    }


    public static void createNewContacttxt() throws Exception
    {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(); // Emory
        firstNameTxtbox.sendKeys(firstName);
        String mobileNumber = generateRandomNumber();
        //Thread.sleep(2000);
        mobileNoField.sendKeys(mobileNumber);
    }

    private static String generateRandomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static void enterEmailID()
    {
        emaiIDField.sendKeys(getEmailID());
    }

    private static CharSequence getEmailID() {
        String str= RandomStringUtils.randomAlphanumeric(10);
        String ssFinal = str.concat("@gmail.com");
        return ssFinal;
        //return RandomStringUtils.randomAlphanumeric(10);
    }

    public static boolean clickSaveBtn()
    {
        saveBtnClick.click();
        return true;
    }



    public static boolean clickDialerTab()
    {
        dialerNumberbtn.click();
        dialerCallBtn.click();
        dialerCallBtn.click();

        return true;
    }

    public static boolean clickEndCallBtn()
    {
        endCallBtnClick.click();
        return true;
    }

    /**
     *
     * for verifying created contact visible or not!!!
     */


    public static void clickContactTab()
    {
        contactTabClick.click();

    }

    public static String getFirstName()
    {
        try
        {

           String firstName = rd.getFirstName();
           return firstName;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static boolean verifyCreatedContactIsVisibleOnContactList() throws Exception
    {
       firstNameTxtbox.sendKeys(getFirstName());
        saveBtnClick.click();
       return true;

    }





}
