package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver wd;

    @Test
    public void loginPositive(){

        wd = new ChromeDriver();
        wd.manage().window().maximize(); //открыть окно на максимальный размер
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //задержка на 5 секунд
        wd.navigate().to("https://trello.com/");
        WebElement loginButton = wd.findElement(By.cssSelector("[href = '/login']"));
        loginButton.click();

        WebElement emailInput = wd.findElement(By.cssSelector("#user"));
        emailInput.click(); //нажать
        emailInput.clear(); //очистить
        emailInput.sendKeys("Irina.Tsygankova61@gmail.com");

        WebElement atlassianButton = wd.findElement(By.cssSelector("#login"));
        atlassianButton.click();

        WebElement passInput = wd.findElement(By.cssSelector("#password"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("123TrellO#");

        WebElement submitButton = wd.findElement(By.cssSelector("#login-submit"));
        Assert.assertTrue(isLogged());
       // wd.close();

    }

    public boolean isLogged(){
    return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size()>0;
    }

}
