package br.edu.catolica.seller_ms.mapper;

import br.edu.catolica.seller_ms.domain.Seller;
import br.edu.catolica.seller_ms.dto.SellerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    Seller dtoToEntity(SellerDTO sellerDTO);
}
