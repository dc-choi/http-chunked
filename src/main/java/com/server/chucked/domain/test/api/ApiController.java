package com.server.chucked.domain.test.api;

import com.server.chucked.domain.test.application.ApiService;
import com.server.chucked.domain.test.dto.MyObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        byte[] bytes = apiService.getChuck().getBytes();

        return outputStream -> {
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

    @GetMapping("{id}")
    public ResponseEntity<String> myMethod(@PathVariable("id") Long id, @ModelAttribute MyObject myObject) {
        System.out.println(id);
        System.out.println(myObject);

        return ResponseEntity.ok("");
    }
}
