package kz.aptekaplus.controller;

import jakarta.validation.constraints.Positive;
import kz.aptekaplus.dto.product.ProductRequestDto;
import kz.aptekaplus.dto.product.ProductResponseDto;
import kz.aptekaplus.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductService productService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getById(@PathVariable UUID id){
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createCategory(@ModelAttribute ProductRequestDto requestDto){
        return productService.create(requestDto);
    }

    @PutMapping(("/{id}"))
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductResponseDto updateCategory(@PathVariable("id") UUID id,@RequestBody @Validated ProductRequestDto requestDto){
        return productService.update(id,requestDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(
            @RequestParam("id") UUID id
    ) {
        productService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }
}
