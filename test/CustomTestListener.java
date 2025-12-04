package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomTestListener extends RunListener {
    private final Set<Description> failedTests = new HashSet<>();
    private long startTime;

    @Override
    public void testStarted(Description description) throws Exception {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void testFinished(Description description) throws Exception {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // Only print success if this test is NOT in failedTests
        if (!failedTests.contains(description)) {
            System.out.println("SUCCESS: " + description.getDisplayName() + " took " + duration + " milliseconds.");
        }
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        failedTests.add(failure.getDescription());
        System.err.println("FAILURE: " + failure.getDescription().getDisplayName() + " - " + failure.getMessage());
    }
}
