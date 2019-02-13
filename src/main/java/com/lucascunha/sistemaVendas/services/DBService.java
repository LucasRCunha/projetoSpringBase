package com.lucascunha.sistemaVendas.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucascunha.sistemaVendas.domain.Cliente;
import com.lucascunha.sistemaVendas.enums.TipoCliente;
import com.lucascunha.sistemaVendas.repositories.ClienteRepository;


@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private ClienteRepository clienteRepository;


	public void instantiateTestDatabase() throws ParseException {

		
		Cliente cli1 = new Cliente(null, "Lucas Cunha", "lucasrcunha01@gmail.com", "36378912377",TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		clienteRepository.saveAll(Arrays.asList(cli1));
				
	}
}