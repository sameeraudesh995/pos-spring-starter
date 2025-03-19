package com.pos_system.itp.service;


import com.pos_system.itp.dto.request.CustomerRequestDto;
import com.pos_system.itp.dto.response.CustomerResponseDto;
import com.pos_system.itp.dto.response.paginate.CustomerPaginatedDto;
import com.pos_system.itp.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void createCustomer(CustomerRequestDto dto);
    public void updateCustomer(CustomerRequestDto dto, String id);
    public void deleteCustomer(String id);
    public CustomerResponseDto getCustomer(String id);
    public void manageStatus(String id);
    public CustomerPaginatedDto search(
            String searchText, int page, int size
    );
    public List<Customer> getAllCustomer();
}
