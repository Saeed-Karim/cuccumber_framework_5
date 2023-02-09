package steps;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Driver;
import utils.Waiter;

public class RandomSteps {


    @Test
    public void getRandomData(){
        Faker faker = new Faker();

        Driver.getDriver().get("https://www.google.com/");
        String chuck = faker.chuckNorris().fact();

        Driver.getDriver().findElement(By.name("q")).sendKeys(chuck + Keys.ENTER);
        for (int i = 0; i < 20; i++) {
            System.out.println(faker.chuckNorris().fact());
            System.out.println(faker.funnyName().name());
        }

        Waiter.pause(3);


        Driver.quitDriver();

    }
}