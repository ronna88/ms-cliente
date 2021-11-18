package br.com.ronna.ms.cliente.services;

import br.com.ronna.ms.cliente.dtos.ClienteDto;
import br.com.ronna.ms.cliente.enums.StatusCliente;
import br.com.ronna.ms.cliente.models.ClienteModel;
import br.com.ronna.ms.cliente.repositories.ClienteRepository;
import br.com.ronna.ms.cliente.vo.ContratoModel;
import br.com.ronna.ms.cliente.vo.EmpresaModel;
import br.com.ronna.ms.cliente.vo.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;


    public ClienteModel createCliente(ClienteModel clienteModel) {
        clienteModel.setClienteCreated(LocalDateTime.now());
        clienteModel.setClienteUpdated(clienteModel.getClienteCreated());
        if(clienteModel.getClienteStatus() == null){
            clienteModel.setClienteStatus(StatusCliente.ACTIVE);
        }
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> listCliente() {
        return clienteRepository.findAll();
    }

    public ClienteModel saveCliente(ClienteModel clienteModel) {
        System.out.println(clienteModel.getClienteId());
        ClienteModel clienteEdit = clienteRepository.getById(clienteModel.getClienteId());

        BeanUtils.copyProperties(clienteModel, clienteEdit);
        clienteEdit.setClienteUpdated(LocalDateTime.now());
        return clienteRepository.save(clienteEdit);
    }

    public ResponseTemplateVO getClienteWithEmpresa(Long clienteId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        ClienteModel clienteModel = clienteRepository.findById(clienteId).get();

        EmpresaModel empresaModel = restTemplate.getForObject("http://localhost:7000/empresa/" + clienteModel.getClienteEmpresaId(), EmpresaModel.class);
        vo.setEmpresaModel(empresaModel);
        ContratoModel contratoModel = restTemplate.getForObject("http://localhost:7002/contrato/" + clienteModel.getClienteContratoId(), ContratoModel.class);
        vo.setContratoModel(contratoModel);

        vo.setClienteModel(clienteModel);

        return vo;
    }

    public ClienteModel getCliente(Long clienteId) {
        return clienteRepository.findById(clienteId).get();
    }
}
