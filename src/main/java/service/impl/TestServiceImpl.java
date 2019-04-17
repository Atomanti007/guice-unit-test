package service.impl;

import dto.Example;
import service.TestService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;

public class TestServiceImpl implements TestService {
    @Override
    public String getString() {
        return "aaa";
    }

    @Override
    public Future<String> getFuture() {
        return CompletableFuture.completedFuture("aaa");
    }

    @Override
    public Future<String> getFuture(String a) {
        return CompletableFuture.completedFuture(a);
    }

    @Override
    public Future getFutureFunction(Function<String, Integer> a) {
        return null;
    }

    @Override
    public Example getExample(String text) {
        Example example = new Example();
        example.setText(text);
        return example;
    }
}
