package br.com.ronna.ms.cliente.controllers;

import br.com.ronna.ms.cliente.dtos.ClienteDto;
import br.com.ronna.ms.cliente.models.ClienteModel;
import br.com.ronna.ms.cliente.services.ClienteService;
import br.com.ronna.ms.cliente.vo.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente/create-cliente")
    public ResponseEntity<ClienteModel> createCliente(@RequestBody @Valid ClienteDto clienteDto) {
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteService.createCliente(clienteModel);
        return new ResponseEntity<>(clienteModel, HttpStatus.CREATED);
    }

    @PutMapping("/cliente/edit-cliente/{id}")
    public ClienteModel updateCliente(@RequestBody ClienteModel clienteModel) {
        System.out.println(clienteModel.getClienteId());
        return clienteService.saveCliente(clienteModel);
    }

    @GetMapping("/cliente/list-cliente")
    public List<ClienteModel> listCliente() {
        return clienteService.listCliente();
    }

    @GetMapping("/cliente/{id}")
    public ClienteModel getEmpresa(@PathVariable("id") Long clienteId) {
        return clienteService.getCliente(clienteId);
    }

    @GetMapping("/cliente/{id}/full")
    public ResponseTemplateVO getClienteWithEmpresa(@PathVariable("id") Long clienteId){
        return clienteService.getClienteWithEmpresa(clienteId);
    }


}
