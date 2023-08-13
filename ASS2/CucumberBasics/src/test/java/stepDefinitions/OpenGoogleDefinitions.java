package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class StepDefinitions {

    public class ShoppingCartStepDefinitions {
        private WebDriver driver;
      
        @Given("the user is on home page")
        public void goToHomepage() {
          driver = new ChromeDriver();
          driver.get("https://www.example.com");
        }
      
        @When("User searches for HP Pen Drive {string}")
        public void searchForItem(String item) {
          WebElement searchBox = driver.findElement(By.id("search-box"));
          searchBox.sendKeys(item);
          searchBox.submit();
        }
      
        @And("the first result on the page with quantity {int}")
        public void addItemToCart(int qty) {
          WebElement addToCartButton = driver.findElement(By.cssSelector("#results .add-to-cart"));
          addToCartButton.click();
          WebElement quantityField = driver.findElement(By.cssSelector("#quantity-field"));
          quantityField.clear();
          quantityField.sendKeys(String.valueOf(qty));
          WebElement updateCartButton = driver.findElement(By.cssSelector("#update-cart-button"));
          updateCartButton.click();
        }
      
        @Then("the cart should display {int} pen drives")
        public void verifyCartContents(int expectedQty) {
          WebElement cart = driver.findElement(By.cssSelector("#cart"));
          List<WebElement> items = cart.findElements(By.cssSelector(".cart-item"));
          int actualQty = items.size();
          assertEquals(expectedQty, actualQty);
        }
      }

}





