package kz.aptekaplus.controller;

import jakarta.validation.constraints.Positive;
import kz.aptekaplus.dto.ProductViewDTO;
import kz.aptekaplus.dto.category.CategoryRequestDto;
import kz.aptekaplus.dto.category.CategoryResponseDto;
import kz.aptekaplus.dto.product.ProductRequestDto;
import kz.aptekaplus.dto.product.ProductResponseDto;
import kz.aptekaplus.service.ProductService;
import kz.aptekaplus.service.impl.CategoryServiceImpl;
import kz.aptekaplus.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productServiceImpl;
    private final CategoryServiceImpl categoryServiceImpl;
    private final ProductService productService;


    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") UUID productId, Model model) {
        ProductViewDTO product = productServiceImpl.getProduct(productId);
        System.out.println(product);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryServiceImpl.getCategories());
        return "product";
    }

    @GetMapping("/get/{id}")
    public String getAllProductsPage(@PathVariable UUID id, Model model){

        List<ProductViewDTO> products = productServiceImpl.findBySubCategoryId(id);
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryServiceImpl.getCategories());
        return "products";
    }


}
