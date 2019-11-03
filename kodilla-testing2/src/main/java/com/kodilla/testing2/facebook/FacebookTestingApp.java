package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    private static final String XPATH_SELECT_DAY = "//*[@id=\"day\"]";
    private static final String XPATH_SELECT_MONTH = "//*[@id=\"month\"]";
    private static final String XPATH_SELECT_YEAR = "//*[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement elementDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        WebElement elementMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        WebElement elementYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));

        while (!driver.findElement(By.xpath(XPATH_SELECT_DAY)).isDisplayed());

        Select selectDay = new Select(elementDay);
        Select selectMonth = new Select(elementMonth);
        Select selectYear = new Select(elementYear);

        selectDay.selectByIndex(27);
        selectMonth.selectByIndex(9);
        selectYear.selectByValue("1993");
    }
}
