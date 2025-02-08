package com.shashwat.crickscores.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.dtos.MatchDto;
import com.shashwat.crickscores.services.MatchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/crickscores")
@Tag(name = "Scores Module", description = "Fetche the scores of games being played on the current date.")
public class CrickScoresController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrickScoresController.class);
	private MatchService matchService;
	
	public CrickScoresController(MatchService ms) {
		this.matchService = ms;
	}
	
	@Operation(
			summary = "Live scores",
			description = "get all the live matches."
			)
	@GetMapping(path = "/live-scores")
	public ResponseEntity<List<MatchDto>> liveScoresHandler(){
		List<MatchDto> liveList = matchService.getLiveMatches();
		LOGGER.info("Live matches : " + liveList.size());
		return new ResponseEntity<List<MatchDto>>(liveList, HttpStatus.OK); 
	}
	
	@Operation(
			summary = "Completed matches",
			description = "get all the matches that were completed today."
			)
	@GetMapping(path = "/completed")
	public ResponseEntity<List<MatchDto>> completedMatchesHandler(){
		List<MatchDto> completedMatchesList = matchService.getCompletedMatches();
		LOGGER.info("completed matches : " + completedMatchesList.size());
		return new ResponseEntity<List<MatchDto>>(completedMatchesList, HttpStatus.OK);
	}
	
	@Operation(
			summary = "All matches",
			description = "get a list of all the matches that are being played today, be it live or completed."
			)
	@GetMapping(path = "/all-matches")
	public ResponseEntity<List<MatchDto>> allMatchesHandler(){
		List<MatchDto> allMatchesList = matchService.getAllMatches();
		LOGGER.info("all matches : " + allMatchesList.size());
		return new ResponseEntity<List<MatchDto>>(allMatchesList, HttpStatus.OK);
	}
}
