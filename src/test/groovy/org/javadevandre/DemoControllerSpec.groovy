//package org.javadevandre
//
//import io.micronaut.context.condition.Failure
//import io.micronaut.http.HttpRequest
//import io.micronaut.http.HttpResponse
//import io.micronaut.http.HttpStatus
//import io.micronaut.http.client.HttpClient
//import io.micronaut.http.client.annotation.Client
//import io.micronaut.test.annotation.MockBean
//import io.micronaut.test.extensions.spock.annotation.MicronautTest
//import io.vavr.control.Try
//import jakarta.inject.Inject
//import spock.lang.Specification
//
//@MicronautTest
//class DemoControllerSpec extends Specification {
//    @Inject
//    private DemoService demoService
//
//    @Inject
//    @Client("/")
//    HttpClient httpClient
//
//    void "Testing VAVR #scenario exception"() {
//        when:
//            Response result = httpClient.toBlocking().retrieve(HttpRequest.GET("/vavr-try?value=" + value), Response)
//        then:
//            demoService.getSomethingWithVavrTry("1") >> Response.builder()
//                    .success(true)
//                    .payload(
//                            Response.Payload.builder()
//                                    .code("222")
//                                    .message("dqweqwe")
//                                    .build())
//                    .build()
//            demoService.getSomethingWithVavrTry("a") >> Try.failure(() -> new DemoException("failure"))
//            result == expectation
////            result == Response.builder()
////                    .success(false)
////                    .payload(
////                            Response.Payload.builder()
////                                    .code("123")
////                                    .message("demo exception was thrown")
////                                    .build())
////                    .build()
//        where:
//            scenario | value   || expectation
//            "TRY"    | "1"     || Response.builder().success(true).payload(Response.Payload.builder().code("222").message("dqweqwe").build()).build()
//            "EITHER" | "a"     || Response.builder().success(false).payload(Response.Payload.builder().code("123").message("demo exception was thrown").build()).build()
//    }
//
//    @MockBean
//    DemoService() {
//        Mock(DemoService)
//    }
//}
