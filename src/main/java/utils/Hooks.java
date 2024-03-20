package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    @Before
    public void beforeScenarios() {
        System.out.println("11111");
    }

    @After
    public void afterScenarios() {
        System.out.println("AFTER");
    }
}
