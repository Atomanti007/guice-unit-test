package adapter;

import com.google.inject.Inject;
import dto.Example;
import service.TestService;

import java.util.concurrent.Future;

public class TestAdapter {

    @Inject
    private TestService testService;

    public String get() {
        return testService.getString();
    }

    public Future getFuture(String a) {
        return testService.getFuture(a);
    }

    public Example getExample(String text) {
        return testService.getExample(text);
    }
}
