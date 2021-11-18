package br.com.ronna.ms.cliente.dtos;

import br.com.ronna.ms.cliente.enums.StatusCliente;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClienteDto {

    @NotBlank
    private String clienteNome;
    private String clienteRazaoSocial;
    @NotBlank
    private String clienteCpfCnpj;
    @NotBlank
    private String clienteEndereco;
    @NotBlank
    private String clienteCEP;
    @NotBlank
    private String clienteBairro;
    @NotBlank
    private String clienteTelefone;
    @NotNull
    private Long clienteEmpresaId;
    @NotNull
    private Long clienteContratoId;

    private StatusCliente statusCliente;
}
