package com.shashwat.crickscores.services;

import java.util.List;

import com.shashwat.crickscores.models.dtos.PlayerRankingDto;

public interface RankingsService {

	List<PlayerRankingDto> getMenBattingTestRankings();
	
	List<PlayerRankingDto> getMenBattingOdiRankings();
	
	List<PlayerRankingDto> getMenBattingT20Rankings();
	
	List<PlayerRankingDto> getMenBowlingTestRankings();
	
	List<PlayerRankingDto> getMenBowlingOdiRankings();
	
	List<PlayerRankingDto> getMenBowlingT20Rankings();
	
	List<PlayerRankingDto> getMenAllRoundersTestRankings();
	
	List<PlayerRankingDto> getMenAllRoundersOdiRankings();
	
	List<PlayerRankingDto> getMenAllRoundersT20Rankings();
}
