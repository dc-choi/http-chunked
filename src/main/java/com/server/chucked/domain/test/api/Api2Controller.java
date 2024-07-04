package com.server.chucked.domain.test.api;

import com.server.chucked.domain.test.dto.TestData;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class Api2Controller {
    @PostMapping()
    public String test(@RequestBody @Valid TestData testData) {
        System.out.println(testData);
        return "Hello World!";
    }
}
