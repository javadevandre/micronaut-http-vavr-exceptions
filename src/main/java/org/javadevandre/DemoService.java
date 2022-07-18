package org.javadevandre;

import io.micronaut.http.HttpResponse;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.inject.Singleton;

@Singleton
public class DemoService {

    public Try<Response> getSomethingWithVavrTry(String value) {
        return Try.of(() -> {
            if ("1".equals(value)) {
                return Response.builder()
                        .success(true)
                        .payload(
                                Response.Payload.builder()
                                        .code("002")
                                        .message("The value is: " + value)
                                        .build())
                        .build();
            } else {
                throw new DemoException("vavr exception");
            }
        });
    }

    public Either<Response, Response> getSomethingWithVavrEither(String value) {
        if ("1".equals(value)) {
            return Either.right(Response.builder()
                    .success(true)
                    .payload(
                            Response.Payload.builder()
                                    .code("002")
                                    .message("The value is: " + value)
                                    .build())
                    .build());
        } else {
            return Either.left(Response.builder()
                    .success(false)
                    .payload(
                            Response.Payload.builder()
                                    .code("003")
                                    .message("Error")
                                    .build())
                    .build());
        }
    }

}
