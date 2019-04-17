package service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.TestService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TestServiceImplTest {

    private static TestService testService;

    @BeforeAll
    static void init() {
        testService = Mockito.mock(TestService.class);
        when(testService.getString()).thenReturn("bbb");
        when(testService.getFuture(any())).thenReturn(CompletableFuture.completedFuture("bbb"));
        when(testService.getFutureFunction(any())).thenReturn(CompletableFuture.completedFuture("bbb"));
    }

    @Test
    void getString() {
        assertEquals("bbb", testService.getString());

    }

    @Test
    void getFuture() throws ExecutionException, InterruptedException {
        assertEquals("bbb", testService.getFuture("aaa").get());
    }

    @Test
    void getFuture1() {
    }

    @Test
    void getFutureFunction() throws ExecutionException, InterruptedException {
        assertEquals("bbb", testService.getFuture("aaa").get());
    }
}