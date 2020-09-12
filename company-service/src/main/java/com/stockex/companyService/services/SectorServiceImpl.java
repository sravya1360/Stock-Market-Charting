package com.stockex.companyService.services;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.dto.IpoDTO;
import com.stockex.companyService.dto.SectorDTO;
import com.stockex.companyService.entity.Ipo;
import com.stockex.companyService.entity.Sector;
import com.stockex.companyService.repository.SectorRepo;

@Service
@Transactional
public class SectorServiceImpl implements SectorService {


	ModelMapper modelMapper;
	SectorRepo sectorRepo;


	public SectorServiceImpl(SectorRepo sectorRepo, ModelMapper modelMapper) {
		this.sectorRepo = sectorRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<SectorDTO> getAll() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<SectorDTO>>() {
		}.getType();
		return modelMapper.map(sectorRepo.findAll(), listType);
	}

	@Override
	public SectorDTO getById(Integer id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(sectorRepo.findById(id), SectorDTO.class);

	}

	@Override
	public List<CompanyDetailsDTO> getAllCompanies(Integer id) {
		Sector sector = sectorRepo.findById(id).orElse(null);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<CompanyDetailsDTO>>() {
		}.getType();
//		return modelMapper.map(sector.getCompanyList(), listType);
		return null;

	}

	@Override
	public SectorDTO addSector(Sector sector) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(sectorRepo.save(sector), SectorDTO.class);
	}

}
