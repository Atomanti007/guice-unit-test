package service;

import dto.Example;

import java.util.concurrent.Future;
import java.util.function.Function;

public interface TestService {
    String getString();

    Future getFuture();

    Future getFuture(String a);

    Future getFutureFunction(Function<String, Integer> a);

    Example getExample(String text);
}
