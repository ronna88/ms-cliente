package br.com.ronna.ms.cliente.models;

import br.com.ronna.ms.cliente.enums.StatusCliente;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;
    private String clienteNome;
    private String clienteRazaoSocial;
    private String clienteCpfCnpj;
    private String clienteEndereco;
    private String clienteCEP;
    private String clienteBairro;
    private String clienteTelefone;
    private Long clienteEmpresaId;
    private Long clienteContratoId;
    private StatusCliente clienteStatus;
    private LocalDateTime clienteCreated;
    private LocalDateTime clienteUpdated;

}
