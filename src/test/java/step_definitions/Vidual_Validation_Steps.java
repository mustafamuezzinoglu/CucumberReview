package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Vidual_validation_shoppingPage;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Vidual_Validation_Steps {

    Vidual_validation_shoppingPage sp = new Vidual_validation_shoppingPage();

    @Then("user see below contents")
    public void user_see_below_contents(Map<String, Object> expected) {
        Map<String, Object> actual = new HashMap<>();
        actual.put("title", sp.title.getText());
        actual.put("subTitle", sp.subTitle.getText());
        actual.put("itemSize", sp.items.size());

        Assert.assertEquals(expected.get("title"),actual.get("title"));
        Assert.assertEquals(expected.get("subTitle"),actual.get("subTitle"));
        Assert.assertEquals(expected.get("itemSize"),String.valueOf(actual.get("itemSize")));



    }
}
