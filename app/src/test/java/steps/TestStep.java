package steps;

import io.cucumber.java.en.Then;
import junit.framework.TestCase;
import pages.TestPage;

public class TestStep {
    TestPage testPage = new TestPage();

    @Then("execute a get")
    public void executeGet() {
        TestCase.assertTrue("Error to realize the get", testPage.executeGet());
    }
}
