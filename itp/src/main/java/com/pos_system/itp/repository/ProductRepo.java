package com.pos_system.itp.repository;


import com.pos_system.itp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, String> {
    @Query(
            value = "SELECT * FROM product WHERE name LIKE %?1% OR description LIKE %?1%",
            nativeQuery = true
    )
    public Page<Product> search(
            String searchText, Pageable pageable
    );
    @Query(
            value = "SELECT COUNT(*) FROM product WHERE name LIKE %?1% OR description LIKE %?1%",
            nativeQuery = true
    )
    public Long searchCount(
            String searchText
    );
}
