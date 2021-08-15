import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("write your user name in Ashkelon college:");
            String userName = scanner.next();
            System.out.println("write your user password in Ashkelon college:");
            String password = scanner.next();
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\97252\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        WebElement menu = driver.findElement(By.className("top-header-menu"));
        if (menu != null) {
            List<WebElement> menuItems = menu.findElements(By.tagName("li"));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            for (int i = 0; i <= menuItems.size(); i++) {
                WebElement menuItem = menuItems.get(i);
                if (menuItem.getText().contains("מידע אישי")) {
                    menuItem.click();
                    break;
                }
            }
        }

        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
        if (userNameInput != null) {
            userNameInput.sendKeys(userName);
        }
        WebElement usernameInput = driver.findElement(By.id("Ecom_Password"));
        if (usernameInput != null) {
            usernameInput.sendKeys(password);
        }
        List<WebElement> enter = driver.findElements(By.className("submit"));
        WebElement logIn = enter.get(0);
        logIn.click();

        driver.findElement(By.linkText("מערכת Moodle")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("usertext")).click();
        driver.findElement(By.id("actionmenuaction-6")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("יציאה")).click();
    }
}