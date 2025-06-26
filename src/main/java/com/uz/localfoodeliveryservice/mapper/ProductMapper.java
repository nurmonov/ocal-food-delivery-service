package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.request.ProductRequest;
import com.uz.localfoodeliveryservice.dto.response.ProductResponse;
import com.uz.localfoodeliveryservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product product(ProductRequest productRequest);

    ProductResponse productResponse(Product product);

}
