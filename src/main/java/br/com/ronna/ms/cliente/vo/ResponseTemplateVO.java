package br.com.ronna.ms.cliente.vo;

import br.com.ronna.ms.cliente.models.ClienteModel;
import lombok.Data;

@Data
public class ResponseTemplateVO {
    private ClienteModel clienteModel;
    private ContratoModel contratoModel;
    private EmpresaModel empresaModel;

}
