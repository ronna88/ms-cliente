package br.com.ronna.ms.cliente.vo;

import lombok.Data;

@Data
public class EmpresaModel {

    private Long empresaId;
    private String empresaNome;
    private String empresaRazaoSocial;
    private String empresaCNPJ;
    private String empresaTelefone;
    private String empresaEndereco;

}
