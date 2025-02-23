package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;

    @FindBy(xpath = "(//i[contains(@class,'oxd-icon bi-caret-down-fill')])[2]")
    WebElement clickFieldUserRole;

    @FindBy(xpath = "(//i[contains(@class,'oxd-icon bi-caret-down-fill')])[3]")
    WebElement clickFieldStatus;

    @FindBy(xpath = "//div[@role='option' and contains(., 'Admin')]")
    WebElement clickListDropdownAdmin;

    @FindBy(xpath = "//div[@role='option' and contains(., 'Enabled')]")
    WebElement clickListDropdownEnabled;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement usernameField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPasswordField;

    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement fieldFullName;

    @FindBy(xpath = "//span[normalize-space()='Peter Mac Anderson']")
    WebElement listFullName;

    @FindBy(css = "div.oxd-table-row")
    List<WebElement> userRows;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
    }

    public void clickFieldUserRole() {
        wait.until(ExpectedConditions.visibilityOf(clickFieldUserRole));
        clickFieldUserRole.click();
    }

    public void clickListDropdownAdmin() {
        wait.until(ExpectedConditions.visibilityOf(clickListDropdownAdmin));
        clickListDropdownAdmin.click();
    }

    public void clickFieldStatus() {
        wait.until(ExpectedConditions.visibilityOf(clickFieldStatus));
        clickFieldStatus.click();
    }

    public void clickListDropdownEnabled() {
        wait.until(ExpectedConditions.visibilityOf(clickListDropdownEnabled));
        clickListDropdownEnabled.click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String ConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        confirmPasswordField.sendKeys(ConfirmPassword);
    }

    public void enteredFullName(String fullName) {
        wait.until(ExpectedConditions.visibilityOf(fieldFullName));
        fieldFullName.sendKeys(fullName);
        try {
            Thread.sleep(2000); // Menunggu 10 detik (10000 milidetik)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickListFullName() {
        wait.until(ExpectedConditions.visibilityOf(listFullName));
        listFullName.click();
    }

    public void clickSaveButton() {
        try {
            Thread.sleep(2000); // Menunggu 10 detik (10000 milidetik)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.sendKeys(Keys.ENTER);
    }

    public boolean isUserInList(String username) {
        wait.until(ExpectedConditions.visibilityOfAllElements(userRows));
        for (WebElement row : userRows) {
            String rowText = row.getText();
            if (rowText.contains(username)) {
                return true;
            }
        }
        return false;
    }
}