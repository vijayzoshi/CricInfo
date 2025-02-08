package com.shashwat.crickscores.services;

import java.util.List;

import com.shashwat.crickscores.models.dtos.MatchDto;

public interface MatchService {

	List<MatchDto> getLiveMatches();
	
	List<MatchDto> getCompletedMatches();
	
	List<MatchDto> getAllMatches();
}
