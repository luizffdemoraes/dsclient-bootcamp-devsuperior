package br.com.lffm.dsclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lffm.dsclient.dto.ClientDTO;
import br.com.lffm.dsclient.entities.Client;
import br.com.lffm.dsclient.repositories.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.el.stream.Optional;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;


	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		return new ClientDTO(entity);
		
	}
	

	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}


	public ClientDTO findById(Long id) throws Exception {
		java.util.Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new Exception("Entity not found"));
		return new ClientDTO(entity);
	}

	
	
	
	

}
