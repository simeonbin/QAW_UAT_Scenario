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
import java.util.ArrayList;
import java.util.List;
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
    
    public static void GivenIAmOnQAWorksCareers()
    {
        // GoTo 'Careers'
        driver.navigate().to("http://careers.qaworks.com/");        
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
    
     public static void ThenJobsTitle_ShortDesc_FullDescIs()
    {
        // int j =0;
        // Grab the table 
        WebElement table = driver.findElement(By.id("jobListings")); 

        //Get number of rows in table 
        int numOfRow = table.findElements(By.tagName("tr")).size(); 
         List <String> jobLinkUrl = new ArrayList(numOfRow);
         
        for  (int j=1; j <= (numOfRow - 2); j=(j+2) ) {
       
             String first_part_jobShortDesc_xpath= "//*[@id='jobListings']/tbody/tr[";
             String second_part_jobShortDesc_xpath= "]/td/span";
             
             String first_part_jobLinkTitle_xpath= "//*[@id='jobListings']/tbody/tr[";
             String second_part_jobLinkTitle_xpath= "]/td/a";
             
             String first_part_jobLinkUrl_xpath= "//*[@id='jobListings']/tbody/tr[";
             String second_part_jobLinkUrl_xpath = "]/td/a";
             
            WebElement webJobLinkUrl = driver.findElement(By.xpath( first_part_jobLinkUrl_xpath + (j+2) + second_part_jobLinkUrl_xpath ) );
            jobLinkUrl.add( webJobLinkUrl.getAttribute("href") );
//                   
             String final_jobLinkTitle_xpath = first_part_jobLinkTitle_xpath + (j+2) + second_part_jobLinkTitle_xpath;
             String final_jobShortDesc_xpath = first_part_jobShortDesc_xpath + (j+3) + second_part_jobShortDesc_xpath;
                     
             WebElement webJobLinkTitle = driver.findElement(By.xpath( final_jobLinkTitle_xpath ) );
             String jobLinkTitle = webJobLinkTitle.getText();
        
             WebElement webJobShortDesc = driver.findElement(By.xpath( final_jobShortDesc_xpath ) );
             String jobShortDesc = webJobShortDesc.getAttribute("innerHTML");
        
            System.out.println("Job Title = " + jobLinkTitle);
            System.out.println();
        
            System.out.println("Short Description of Job = " + jobShortDesc);
            System.out.println();
        
            System.out.println("Link URL of Job" + jobLinkUrl);
            System.out.println();
        }
        
//        // GoTo 'Full Job Description'
           for (int i=0; i < jobLinkUrl.size(); i++ ) {
               
             driver.navigate().to(jobLinkUrl.get(i));        
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
//          
          WebElement webJobFullDescData = driver.findElement(By.xpath("//*[@id='jobDetails']/div[2]/table/tbody/tr[1]/td") );
          String jobFullDescData = webJobFullDescData.getText();
//     
            System.out.println("Job Full Description Data" + jobFullDescData);
          System.out.println();
           
        }
    }
    
   public static void main(String[] args) throws IOException {
      
           GivenIAmOnQAWorks();
            String name = "Bloggs"; String email = "j.Bloggs@qaworks.com"; 
            String message = "Please contact me I want to find out more";
            ThenContactInfoIs(name, email, message);
        
            GivenIAmOnQAWorksCareers();
            ThenJobsTitle_ShortDesc_FullDescIs();
        
    }
   
}
