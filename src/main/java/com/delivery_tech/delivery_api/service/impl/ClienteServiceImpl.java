package com.delivery_tech.delivery_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delivery_tech.delivery_api.dto.request.ClienteRequest;
import com.delivery_tech.delivery_api.model.Cliente;
import com.delivery_tech.delivery_api.repository.ClienteRepository;
import com.delivery_tech.delivery_api.service.ClienteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente cadastrar(ClienteRequest clienteRequest) {
        log.info("Iniciando cadastro de cliente: {}", clienteRequest.getEmail());

        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setTelefone(clienteRequest.getTelefone());
        cliente.setEndereco(clienteRequest.getEndereco());

        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + cliente.getEmail());
        }

        validarDadosCliente(cliente);

        cliente.setAtivo(true);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        log.info("Cliente cadastrado com sucesso - ID: {}", clienteSalvo.getId());

        return clienteSalvo;
    }
}
