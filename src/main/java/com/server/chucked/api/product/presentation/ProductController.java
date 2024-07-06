package com.server.chucked.api.product.presentation;

import com.server.chucked.api.product.application.ProductService;
import com.server.chucked.api.product.presentation.dto.CreateProductExternalDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

//    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
//    public StreamingResponseBody getChuck() {
//        byte[] bytes = testService.getChuck().getBytes();
//
//        return outputStream -> {
//            List<Byte> byteList = new ArrayList<>();
//
//            for (byte aByte : bytes) {
//                byteList.add(aByte);
//            }
//
//            for (Byte split : byteList) {
//                outputStream.write(split);
//                outputStream.flush();
//            }
//        };
//    }

//    @GetMapping("{id}")
//    public ResponseEntity<String> myMethod(@PathVariable("id") Long id, @ModelAttribute MyObject myObject) {
//        System.out.println(id);
//        System.out.println(myObject);
//
//        return ResponseEntity.ok("");
//    }

    @PostMapping("/test")
    public CreateProductExternalDto.Response create(
            @Valid @RequestBody final CreateProductExternalDto.Request request
    ) {
        return productService.create(request);
    }

//    @PostMapping("test2")
//    public String test(@RequestBody @Valid TestData testData) {
//        System.out.println(testData);
//        return "Hello World!";
//    }
}
