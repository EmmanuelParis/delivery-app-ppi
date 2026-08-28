package br.edu.catolica.seller_ms.controller;

import br.edu.catolica.seller_ms.constants.SellerConstants;
import br.edu.catolica.seller_ms.dto.SellerDTO;
import br.edu.catolica.seller_ms.dto.ResponseDTO;
import br.edu.catolica.seller_ms.service.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.edu.catolica.seller_ms.constants.SellerConstants.SELLER_MESSAGE_201;
import static br.edu.catolica.seller_ms.constants.SellerConstants.SELLER_MESSAGE_400;
import static br.edu.catolica.seller_ms.constants.SellerConstants.SELLER_MESSAGE_500;

@RestController
@RequestMapping("/api/vi/seller")
@RequiredArgsConstructor
@Tag(name = "Seller", description = "Recursos para gerenciamento de sellers")
public class SellerController {

    private final SellerService sellerService;

    @Operation(summary = "Cadastrar Vendedor", description = "Método POST para cadastrar um seller na base de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = SELLER_MESSAGE_201),
            @ApiResponse(responseCode = "400", description = SELLER_MESSAGE_400),
            @ApiResponse(responseCode = "500", description = SELLER_MESSAGE_500)
    })
    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody @Valid SellerDTO sellerDTO){
        sellerService.save(sellerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(SELLER_MESSAGE_201, HttpStatus.CREATED.value()));
    }
}
