package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new CustomTestListener()); 
        Result result = junit.run(TestZooOperations.class); 

        System.out.println("\n--- Test Summary ---");
        System.out.println("Total tests run: " + result.getRunCount());
        System.out.println("Failures: " + result.getFailureCount());
        System.out.println("Ignored tests: " + result.getIgnoreCount());
        System.out.println("Was successful: " + result.wasSuccessful());
    }
    
} 
