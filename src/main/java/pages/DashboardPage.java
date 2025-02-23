package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    WebElement dashboardHeader;

    @FindBy(css = "span.oxd-text.oxd-text--span.oxd-main-menu-item--name")
    WebElement adminMenu;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getDashboardHeaderText(){
        wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
        return dashboardHeader.getText();
    }

    public void clickAdminMenu() {
        wait.until(ExpectedConditions.visibilityOf(adminMenu));
        adminMenu.click();
    }
}
