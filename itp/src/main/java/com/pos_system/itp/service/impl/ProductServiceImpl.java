package com.pos_system.itp.service.impl;

import com.pos_system.itp.dto.request.ProductRequestDto;
import com.pos_system.itp.dto.response.CustomerResponseDto;
import com.pos_system.itp.dto.response.ProductResponseDto;
import com.pos_system.itp.dto.response.paginate.CustomerPaginatedDto;
import com.pos_system.itp.dto.response.paginate.ProductPaginatedDto;
import com.pos_system.itp.entity.Customer;
import com.pos_system.itp.entity.Product;
import com.pos_system.itp.exception.EntryNotFoundException;
import com.pos_system.itp.repository.ProductRepo;
import com.pos_system.itp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;
    private final ProductRepo productRepo;

    @Override
    public void createProduct(ProductRequestDto dto) {
        repo.save(toProduct(dto));
    }

    @Override
    public void updateProduct(ProductRequestDto dto, String id) {
        Optional<Product> selectedProduct =
                repo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product Not Found"); // this must be an entry not found exception
        }
        selectedProduct.get().setName(dto.getName());
        selectedProduct.get().setDescription(dto.getDescription());
        selectedProduct.get().setPrice(dto.getPrice());
        selectedProduct.get().setQuantity(dto.getQuantity());
        repo.save(selectedProduct.get());

    }

    @Override
    public void deleteProduct(String id) {
        repo.deleteById(id);
    }

    @Override
    public ProductResponseDto getProduct(String id) {

        Optional<Product> selectedProduct = repo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product Not Found"); // this must be an entry not found exception
        }
        return toProductResponseDto(
                selectedProduct.get()
        );
    }

    @Override
    public ProductPaginatedDto search(String searchText, int page, int size) {
        return ProductPaginatedDto
                .builder()
                .dataList(
                        repo.search(
                                        searchText,
                                        PageRequest.of(
                                                page,size
                                        )
                                ).map(e->toProductResponseDto(e))
                                .stream().toList()
                )
                .count(
                        repo.searchCount(searchText)
                ).build();
    }

    @Override
    public List<Product> getAllProducts() {
       return repo.findAll();
    }

    private Product toProduct(ProductRequestDto dto) {
        return Product.builder().productId(generateProductId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity()).build();

    }

    private ProductResponseDto toProductResponseDto(
            Product p
    ){
        return p==null?null:  ProductResponseDto.
                builder()
                .id(p.getProductId())
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .quantity(p.getQuantity()).build();
    }

    private String generateProductId() {
        // Implement logic to generate a unique order ID (e.g., UUID or timestamp-based)
        return "PRO-" + System.currentTimeMillis();
    }
}
