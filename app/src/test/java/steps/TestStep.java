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

    @Then("execute a POST")
    public void executePOST() {
        TestCase.assertTrue("Error to realize the get", testPage.executePOST());
    }

    @Then("execute a PUT")
    public void executePUT() {
        TestCase.assertTrue("Error to realize the get", testPage.executePUT());
    }

    @Then("execute a DELETE")
    public void executeDELETE() {
        TestCase.assertTrue("Error to realize the get", testPage.executeDELETE());
    }
}
