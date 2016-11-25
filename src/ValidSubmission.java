/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simeon
 */
import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// [Binding]
public class ValidSubmission {

    private static WebDriver driver = new FirefoxDriver();
    public ValidSubmission()
    {
        driver = new FirefoxDriver();
       // String @"http://www.qaworks.com" ;
    }
 
 //   [Given(@"I am on the QAWorks site")]
    public static void GivenIAmOnQAWorks()
    {
        // GoTo 'Contact'
        driver.navigate().to("http://www.qaworks.com/contact.aspx");        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        
    }
 
 //   [When(@"I transfer (.*)€")]
    
//    public void WhenITransfer50(string amount)
//    {
//        driver.FindElement(By.Id("amount")).SendKeys(amount);
//        driver.FindElement(By.Id("submitBtn")).Click();
//    }
 
//    [Then(@"I should be able to contact QAWorks with the following information")]
    public static void ThenContactInfoIs(String name, String email, String message)
    {
        // xpath --> //*[@id='ctl00_MainContent_NameBox']
        // String nameForContact = 
                driver.findElement(By.id("ctl00_MainContent_NameBox") ).sendKeys(name);
        // assertEquals(nameForContact, ("Bloggs"));
        
        //xpath --> //*[@id='ctl00_MainContent_EmailBox']
        // String emailForContact = 
                driver.findElement(By.id("ctl00_MainContent_EmailBox")).sendKeys(email);
        // assertEquals(emailForContact, ("j.Bloggs@qaworks.com"));
        
        //xpath --> //*[@id='ctl00_MainContent_MessageBox']
        // String messageForContact = 
                driver.findElement(By.id("ctl00_MainContent_MessageBox")).sendKeys(message);
        // assertEquals(messageForContact, ("Please contact me I want to find out more"));
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //xpath --> //*[@id='ctl00_MainContent_SendButton']
       // driver.findElement(By.id("ctl00_MainContent_SendButton")).click();
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_SendButton']")).submit();
        
    }
    
   public static void main(String[] args) throws IOException {
      
        GivenIAmOnQAWorks();
        String name = "Bloggs"; String email = "j.Bloggs@qaworks.com"; 
        String message = "Please contact me I want to find out more";
        ThenContactInfoIs(name, email, message);
        
    }
   
}
