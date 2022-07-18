package org.javadevandre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Response {
    private boolean success;
    private Payload payload;

    // For testing only
    public Response() {
        this(true, new Payload());
    }

    @Data
    @Builder
    @AllArgsConstructor
    static class Payload {
        private String code;
        private String message;

        // For testing only
        public Payload() {
            this("???", "testing message");
        }

    }
}
