package com.server.chucked.api;

import com.server.chucked.application.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public StreamingResponseBody getChuck() {
        return outputStream -> {
            byte[] bytes = apiService.getChuck().getBytes();

            List<Byte> byteList = new ArrayList<>();
            for (byte aByte : bytes) {
                byteList.add(aByte);
            }

            for (Byte split : byteList) {
                outputStream.write(split);
                outputStream.flush();
            }
        };
    }
}
