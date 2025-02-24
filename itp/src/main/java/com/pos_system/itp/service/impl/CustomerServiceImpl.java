package com.pos_system.itp.service.impl;


import com.pos_system.itp.dto.request.CustomerRequestDto;
import com.pos_system.itp.dto.response.CustomerResponseDto;
import com.pos_system.itp.dto.response.paginate.CustomerPaginatedDto;
import com.pos_system.itp.entity.Customer;
import com.pos_system.itp.exception.EntryNotFoundException;
import com.pos_system.itp.repository.CustomerRepo;
import com.pos_system.itp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo repo;

    @Override
    public void createCustomer(CustomerRequestDto dto) {
        repo.save(toCustomer(dto));
    }

    @Override
    public void updateCustomer(CustomerRequestDto dto, String id) {
        Optional<Customer> selectedCustomer =
                repo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new EntryNotFoundException("Customer Not Found"); // this must be an entry not found exception
        }
        selectedCustomer.get().setName(dto.getName());
        selectedCustomer.get().setAddress(dto.getAddress());
        selectedCustomer.get().setSalary(dto.getSalary());
        repo.save(selectedCustomer.get());
    }

    @Override
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        Optional<Customer> selectedCustomer = repo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new EntryNotFoundException("Customer Not Found"); // this must be an entry not found exception
        }
        return toCustomerResponseDto(
                selectedCustomer.get()
        );
    }

    @Override
    public void manageStatus(String id) {
        Optional<Customer> selectedCustomer = repo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new EntryNotFoundException("Customer Not Found"); // this must be an entry not found exception
        }
        selectedCustomer.get()
                .setStatus(
                        !selectedCustomer.get()
                                .isStatus()
                );

    }

    @Override
    public CustomerPaginatedDto search(String searchText, int page, int size) {
        return CustomerPaginatedDto
                .builder()
                .dataList(
                        repo.search(
                                searchText,
                                PageRequest.of(
                                        page,size
                                )
                        ).map(e->toCustomerResponseDto(e))
                                .stream().toList()
                )
                .count(
                        repo.searchCount(searchText)
                ).build();
    }

    private Customer toCustomer(
            CustomerRequestDto dto
    ){
        return  Customer.builder()
                .customerId(
                        UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .salary(dto.getSalary())
                .status(true).build();
    }
    private CustomerResponseDto toCustomerResponseDto(
            Customer c
    ){
        return c==null?null:  CustomerResponseDto.
                builder()
                .id(c.getCustomerId())
                .name(c.getName())
                .address(c.getAddress())
                .salary(c.getSalary())
                .status(c.isStatus()).build();
    }

}
