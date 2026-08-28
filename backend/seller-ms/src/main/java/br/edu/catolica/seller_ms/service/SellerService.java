package br.edu.catolica.seller_ms.service;

import br.edu.catolica.seller_ms.domain.Seller;
import br.edu.catolica.seller_ms.dto.SellerDTO;
import br.edu.catolica.seller_ms.exception.SellerException;
import br.edu.catolica.seller_ms.mapper.SellerMapper;
import br.edu.catolica.seller_ms.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellerService {

    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;


    public void save(SellerDTO sellerDTO){
        try{
            Seller seller = sellerMapper.dtoToEntity(sellerDTO);
            sellerRepository.save(seller);
        } catch (Exception e) {
            log.error("m=save, Error while trying to save seller with cpf = {}", sellerDTO.cpf(), e);
            throw new SellerException(e.getMessage());
        }{

        }
    }
}
