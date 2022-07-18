package org.javadevandre;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
public class DemoExceptionHandler implements ExceptionHandler<DemoException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, DemoException exception) {
        return HttpResponse.noContent();
    }
}
