package com.stockex.companyService.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.dto.IpoDTO;
import com.stockex.companyService.entity.Ipo;
import com.stockex.companyService.repository.IpoRepo;

@Service
@Transactional
public class IpoServiceImpl implements IpoService {
	ModelMapper modelMapper;
	IpoRepo ipoRepo;

	public IpoServiceImpl(IpoRepo ipo, ModelMapper modelMapper) {
		this.ipoRepo = ipo;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<IpoDTO> getAllIpos() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<IpoDTO>>() {
		}.getType();
		return modelMapper.map(ipoRepo.findAll(), listType);
	}

	@Override
	public IpoDTO getById(Integer id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(ipoRepo.findById(id), IpoDTO.class);
	}

	@Override
	public List<IpoDTO> getIpoOfCompany(String companyName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<IpoDTO>>() {
		}.getType();
		return modelMapper.map(ipoRepo.findByCompanyName(companyName), listType);
	}

	@Override
	public IpoDTO addIpo(Ipo ipoDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(ipoRepo.save(ipoDetails), IpoDTO.class);
	}

}
