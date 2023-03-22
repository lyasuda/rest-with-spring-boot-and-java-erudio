package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;


@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding All People!");

		return DozerMapper.parseListObjects(this.repository.findAll(), PersonVO.class);
	}

	public PersonVO create(PersonVO person) {

		logger.info("Creating one Person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(this.repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 personVOV2) {

		logger.info("Creating one Person winth V2!");
		
		var entity = mapper.convertVoTOEntity(personVOV2);

		var vo = mapper.convertEntityToVo(this.repository.save(entity));
		
		return vo;
	}
	
	public PersonVO update(PersonVO personVO) {
		
		logger.info("Updating one Person!");
		
		var entity = this.repository.findById(personVO.getId()).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());
		
		var vo = DozerMapper.parseObject(this.repository.save(entity), PersonVO.class);

		return vo; 
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one Person!");
		
		var entity = this.repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		this.repository.delete(entity);
	}
	
	public PersonVO findById(Long id) {		
		
		logger.info("Finding One Person");		

		var entity =  this.repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
	}

}
