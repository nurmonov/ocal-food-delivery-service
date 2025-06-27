package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.ProductDto;
import com.uz.localfoodeliveryservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto productRequest);

    ProductDto toDto(Product product);

}
