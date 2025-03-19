package com.pos_system.itp.api;


import com.pos_system.itp.dto.request.ProductRequestDto;
import com.pos_system.itp.entity.Product;
import com.pos_system.itp.service.ProductService;
import com.pos_system.itp.util.StandardResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductController {
        private final ProductService productService;

        @PostMapping("/create")
        public ResponseEntity<StandardResponseDto> createProduct(@RequestBody ProductRequestDto dto) {
            productService.createProduct(dto);
            return new ResponseEntity<>(
                    new StandardResponseDto(
                            201,"product has been saved!",null
                    ),
                    HttpStatus.CREATED
            );
        }

    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponseDto>
    updateProduct(
            @RequestBody ProductRequestDto dto,
            @PathVariable String id
    ){
        productService.updateProduct(dto,id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        201,"product has been updated!",null
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponseDto>
    deleteProduct(
            @PathVariable String id
    ){
        productService.deleteProduct(id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        204,"product has been deleted!",null
                ),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<StandardResponseDto>
    findById(
            @PathVariable String id
    ){
        return new ResponseEntity<>(
                new StandardResponseDto(
                        200,
                        "customer found!",
                        productService.getProduct(id)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/search")
    public ResponseEntity<StandardResponseDto>
    search(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponseDto(
                        200,
                        "product list!",
                        productService.search(searchText, page, size)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponseDto> getAllProducts() {
        return new ResponseEntity<>(
                new StandardResponseDto(
                        200,
                        "Product List",
                        productService.getAllProducts()

                ),HttpStatus.OK


              );
    }
}

