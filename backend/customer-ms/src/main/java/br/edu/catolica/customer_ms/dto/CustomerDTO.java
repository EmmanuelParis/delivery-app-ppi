package br.edu.catolica.customer_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Length;
import org.hibernate.validator.constraints.br.CPF;


@Schema(name = "CustomerDTO", description = "Representação dos dados do Customer")
public record CustomerDTO(

        @Schema(description = "Nome do Cliente", minLength = 2)
        @NotBlank(message = "O Campo Nome é Obrigatório")
        String name,

        @Schema(description = "CPF do Cliente (Apenas Números)", example = "12345678900")
        @NotBlank(message = "O Campo Cpf é Obrigatório")
        @CPF(message = "CPF Inválido")
        String cpf,

        @Schema(description = "Nº de Telefone do Cliente (Apenas Números)", example = "83912345678")
        @NotBlank(message = "O Campo Telefone é Obrigatório")
        @Size(min = 11, max = 11, message = "O Número Do Telefone Deve Conter 11 Dígitos")
        String phoneNumber,

        @Schema(description = "E-mail do Cliente", example = "cliente@email.com")
        @NotBlank(message = "O Campo Email é Obrigatório")
        @Email(message = "E-mail Inválido")
        String email,

        @Schema(description = "Endereço do Cliente")
        @NotNull(message = "O Campo Endereço é Obrigatório")
        @Valid
        AddressDTO address) {
}
