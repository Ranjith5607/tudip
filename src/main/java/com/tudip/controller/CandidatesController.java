package com.tudip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tudip.model.CandidatesModel;
import com.tudip.model.CandidatesResponse;
import com.tudip.service.CandidatesService;
import com.tudip.util.AppConstants;

@RestController
public class CandidatesController {

	@Autowired
	private CandidatesService candidatesService;

	@GetMapping("/fetchAll")
	public List<CandidatesModel> fetchAllCandidates() {

		List<CandidatesModel> fetchAllCandidates = candidatesService.fetchAllCandidates();
		return fetchAllCandidates;
	}

	@PostMapping("/save")
	public String saveCandidates(@RequestBody CandidatesModel candidatesModel) {

		CandidatesModel saveCandidates = candidatesService.saveCandidates(candidatesModel);

		if (saveCandidates != null) {
			return "Success full saved";

		}

		return "Not success full saved";
	}

	@PutMapping("/edit")
	public String editCandidates(@RequestBody List<CandidatesModel> candidatesModel) {

		List<CandidatesModel> editCandidates = candidatesService.editCandidates(candidatesModel);

		if (editCandidates != null) {
			return "Success full saved";

		}

		return "Not success full saved";
	}

	@GetMapping("/getAllCandidates")
	public CandidatesResponse getAllCandidates(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
			@RequestParam(value = "searchName", defaultValue = AppConstants.DEFAULT_SEARCH_NAME, required = false) String searchName) {

		return candidatesService.getAllCandidates(pageNo, pageSize, sortBy, sortDir, searchName);
	}
}
