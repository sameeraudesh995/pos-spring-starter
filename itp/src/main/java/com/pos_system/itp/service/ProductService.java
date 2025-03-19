package com.pos_system.itp.service;

import com.pos_system.itp.dto.request.ProductRequestDto;
import com.pos_system.itp.dto.response.CustomerResponseDto;
import com.pos_system.itp.dto.response.ProductResponseDto;
import com.pos_system.itp.dto.response.paginate.CustomerPaginatedDto;
import com.pos_system.itp.dto.response.paginate.ProductPaginatedDto;
import com.pos_system.itp.entity.Product;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductRequestDto dto);
    public void updateProduct(ProductRequestDto dto, String id);
    public void deleteProduct(String id);
    public ProductResponseDto getProduct(String id);
    public ProductPaginatedDto search(
            String searchText, int page, int size
    );
     public List<Product> getAllProducts();
}
