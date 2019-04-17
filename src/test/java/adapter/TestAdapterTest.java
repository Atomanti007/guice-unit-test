package adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import dto.Example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.TestService;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TestAdapterTest {

    private static Injector injector;

    private static Example readResource(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream resourceAsStream = TestAdapterTest.class.getResourceAsStream("/" + path + ".json");
        return objectMapper.readValue(resourceAsStream, Example.class);
    }

    @BeforeEach
    public void beforeEach() throws IOException {
        TestService test = Mockito.mock(TestService.class);
        when(test.getString()).thenReturn("ddd");
        when(test.getFuture(any())).thenReturn(CompletableFuture.completedFuture("sss"));
        when(test.getExample("test")).thenReturn(readResource("test"));
        when(test.getExample("test2")).thenReturn(readResource("test2"));

        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(TestService.class).toInstance(test);
            }
        });

    }

    @Test
    void get() {
        TestAdapter testAdapter = injector.getInstance(TestAdapter.class);
        assertEquals("ddd", testAdapter.get());
    }

    @Test
    void get2() throws ExecutionException, InterruptedException {

        TestAdapter testAdapter = injector.getInstance(TestAdapter.class);
        assertEquals("sss", testAdapter.getFuture("asd").get());
    }

    @Test
    void test1() {
        TestAdapter testAdapter = injector.getInstance(TestAdapter.class);
        assertEquals("test", testAdapter.getExample("test").getText());
    }

    @Test
    void test2() {
        TestAdapter testAdapter = injector.getInstance(TestAdapter.class);
        assertEquals("test2", testAdapter.getExample("test2").getText());
    }
}