package br.com.lffm.dsclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lffm.dsclient.dto.ClientDTO;
import br.com.lffm.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
//	@Autowired
//	//private ClientService service;
//
//	@PostMapping
//	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
//		dto = service
//		
//	}
}
