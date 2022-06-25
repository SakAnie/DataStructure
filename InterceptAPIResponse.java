package cdp;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.fetch.Fetch;
import org.testng.annotations.Test;

public class InterceptAPIResponse {

	@Test
	public void changeApiResponse() throws InterruptedException {

		// Initialize Driver Instance
		System.setProperty("webdriver.chrome.driver", "chromedriver3");
		ChromeDriver driver = new ChromeDriver();

		// Initialize Chrome Dev Tool Instance
		DevTools chromeDevTools = driver.getDevTools();
		chromeDevTools.createSession();

		// Step1: ENABLE:Enable the Fetch Domain
		chromeDevTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		// Step2: LISTEN: Fire the Event to Manipulate the request, this request will be
		// passed to server until client explcitely says continue Request

		// request call is made from application to Server, this event
		// Fetch.requestPaused() is fired, to which we are listening
		// whenever its fired, we are catching that under whatever it emits, it emites
		// 'request' object
		// out of many api requests , out interest is in the api call which contains
		// shetty in its url
		// so we put a condition

		chromeDevTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("python")) {
				System.out.println(" Condition matched! Going to mock this request!");
				// If condition matches , then only we mock the API call URL
				String mockUrl = request.getRequest().getUrl().replace("python", "Sakshi");
				System.out.println(mockUrl);

				// After Manipulation-->continue the request (resuming)-->all same details we
				// are resending except the URL is now mockUrl
				chromeDevTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockUrl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						Optional.empty()));
				System.out.println(" after mocking, continue request!");

			} else {
				// if does not find any api call having string Shetty

				// send the request as it is with the old url
				chromeDevTools.send(Fetch.continueRequest(request.getRequestId(),
						Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(), Optional.empty()));
				System.out.println(" Not mocked in this Request!!");
			}
		});

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		System.out.println("interception  Test executed  successfully");
		driver.quit();
		// Rest flows for your test

		
		
		
		//https://pagead2.googlesyndication.com/bg/Lm7rFgrIBRo_ITQOHaUzgnXfknBPfX56ETeLWpEgtsk.js
	}

}
