package br.com.lffm.dsclient.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.lffm.dsclient.dto.ClientDTO;
import br.com.lffm.dsclient.entities.Client;
import br.com.lffm.dsclient.repositories.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) throws Exception {
		java.util.Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new Exception("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> finAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) throws Exception {
		try {
			Client entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new Exception("Id not found " + id);
		}

	}

	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}

	
	
	

}
