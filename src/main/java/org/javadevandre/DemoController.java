package org.javadevandre;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

@Controller
public class DemoController {
    @Inject
    private DemoService demoService;

    @Get("/vavr-try")
    public HttpResponse<Response> getSomethingWithVavrTry(@QueryValue String value) {
        return HttpResponse.ok(
                demoService.getSomethingWithVavrTry(value)
                        .onSuccess(response -> {})
                        .onFailure(e -> new DemoException("Try exception"))
                .get());
    }

    @Get("/vavr-either")
    public HttpResponse<Response> getSomethingWithVavrEither(@QueryValue String value) {
        return HttpResponse.ok(
                demoService.getSomethingWithVavrEither(value)
                        .getOrElseThrow(e -> new DemoException("Either exception")));
    }

    @Error
    public HttpResponse<Response> error(HttpRequest request, DemoException e) {
        Response error = Response.builder()
                .success(false)
                .payload(
                        Response.Payload.builder()
                                .code("123")
                                .message("demo exception was thrown")
                        .build())
                .build();
        return HttpResponse.created(error);
    }
}
