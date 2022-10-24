package com.example.threadAboutTest.semaphoreTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    @Test
    public void givenLoginQueue_whenLogout_thenSlotsAvailable() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots - 1);
        IntStream.range(0, slots).forEach(user -> {
            executorService.execute(() -> {
                boolean b = loginQueue.tryLogin();
                System.out.println(b);
            });
        });
        executorService.shutdown();
        assertEquals(0, loginQueue.availableSlots());
        loginQueue.logout();

        assertTrue(loginQueue.availableSlots() > 0);
        assertTrue(loginQueue.tryLogin());
    }
}
