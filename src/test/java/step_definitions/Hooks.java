package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

public class Hooks {


    @Before
    public void init(){
        System.out.println("before every step");
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
