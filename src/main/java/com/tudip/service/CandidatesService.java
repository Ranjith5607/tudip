package com.tudip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tudip.model.CandidatesModel;
import com.tudip.model.CandidatesResponse;
import com.tudip.repository.CandidateRepository;

@Service
public class CandidatesService {

	@Autowired
	private CandidateRepository candidateRepository;

	public List<CandidatesModel> fetchAllCandidates() {

		List<CandidatesModel> findAll = candidateRepository.findAll();

		return findAll;

	}

	public CandidatesModel saveCandidates(CandidatesModel candidatesModel) {

		CandidatesModel save = candidateRepository.save(candidatesModel);

		return save;

	}

	public List<CandidatesModel> editCandidates(List<CandidatesModel> candidatesModel) {

		List<CandidatesModel> saveAll = candidateRepository.saveAllAndFlush(candidatesModel);

		return saveAll;

	}

	public CandidatesResponse getAllCandidates(int pageNo, int pageSize, String sortBy, String sortDir,
			String searchName) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		// Page<CandidatesModel> CandidatesModels =
		// candidateRepository.findAll(pageable);

		CandidatesModel candidatesModel = new CandidatesModel();
		candidatesModel.setCandidateName(searchName);
		candidatesModel.setCandidatePhoneNumber(searchName);
		candidatesModel.setCandidateEmail(searchName);

		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("candidateName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("candidatePhoneNumber", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("candidateEmail", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

		Page<CandidatesModel> CandidatesModels = candidateRepository
				.findAll(Example.of(candidatesModel, customExampleMatcher), pageable);

		// get content for page object
		List<CandidatesModel> listOfCandidatesModel = CandidatesModels.getContent();

		List<CandidatesModel> collect = listOfCandidatesModel.stream().collect(Collectors.toList());

		CandidatesResponse candidatesResponse = new CandidatesResponse();
		candidatesResponse.setCandidatesModel(collect);
		candidatesResponse.setPageNo(CandidatesModels.getNumber());
		candidatesResponse.setPageSize(CandidatesModels.getSize());
		candidatesResponse.setTotalElements(CandidatesModels.getTotalElements());
		candidatesResponse.setTotalPages(CandidatesModels.getTotalPages());
		candidatesResponse.setLast(CandidatesModels.isLast());

		return candidatesResponse;
	}
}
