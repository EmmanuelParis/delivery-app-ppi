package br.edu.catolica.seller_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Length;
import org.hibernate.validator.constraints.br.CPF;


@Schema(name = "SellerDTO", description = "Representação dos dados do Seller")
public record SellerDTO(

        @Schema(description = "Nome do Vendedor", minLength = 2)
        @NotBlank(message = "O Campo Nome é Obrigatório")
        String name,

        @Schema(description = "CPF do Vendedor (Apenas Números)", example = "12345678900")
        @NotBlank(message = "O Campo Cpf é Obrigatório")
        @CPF(message = "CPF Inválido")
        String cpf,

        @Schema(description = "Nº de Telefone do Vendedor (Apenas Números)", example = "83912345678")
        @NotBlank(message = "O Campo Telefone é Obrigatório")
        @Size(min = 11, max = 11, message = "O Número Do Telefone Deve Conter 11 Dígitos")
        String phoneNumber) {

}
