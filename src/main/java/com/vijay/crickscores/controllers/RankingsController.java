package com.shashwat.crickscores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.dtos.PlayerRankingDto;
import com.shashwat.crickscores.services.RankingsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/crickscores/rankings")
@Tag(name = "Rankings Module", description = "Fetch the latest player rankings.")
public class RankingsController {
	
	private RankingsService rankingsService;
	
	public RankingsController(RankingsService rs) {
		this.rankingsService = rs;
	}
	
	@Operation(
			summary = "Test-batsman",
			description = "ICC men's test ranking for batting."
			)
	@GetMapping(path = "/men/batting/test")
	public ResponseEntity<List<PlayerRankingDto>> menBattingTestRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBattingTestRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "ODI-batsman",
			description = "ICC men's ODI ranking for batting."
			)
	@GetMapping(path = "/men/batting/odi")
	public ResponseEntity<List<PlayerRankingDto>> menBattingOdiRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBattingOdiRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "T20-batsman",
			description = "ICC men's t20 ranking for batting."
			)
	@GetMapping(path = "/men/batting/t20")
	public ResponseEntity<List<PlayerRankingDto>> menBattingT20Ranking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBattingT20Rankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "Test-bowler",
			description = "ICC men's test ranking for bowling."
			)
	@GetMapping(path = "/men/bowling/test")
	public ResponseEntity<List<PlayerRankingDto>> menBowlingTestRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBowlingTestRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "ODI-bowling",
			description = "ICC men's ODI ranking for bowling."
			)
	@GetMapping(path = "/men/bowling/odi")
	public ResponseEntity<List<PlayerRankingDto>> menBowlingOdiRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBowlingOdiRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "T20-bowling",
			description = "ICC men's t20 ranking for bowling."
			)
	@GetMapping(path = "/men/bowling/t20")
	public ResponseEntity<List<PlayerRankingDto>> menBowlingT20Ranking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBowlingT20Rankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "Test-all-rounder",
			description = "ICC men's test ranking for all-rounder."
			)
	@GetMapping(path = "/men/all-rounder/test")
	public ResponseEntity<List<PlayerRankingDto>> menAllRounderTestRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenAllRoundersTestRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "ODI-all-rounder",
			description = "ICC men's ODI ranking for all-rounder."
			)
	@GetMapping(path = "/men/all-rounder/odi")
	public ResponseEntity<List<PlayerRankingDto>> menAllRounderOdiRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenAllRoundersOdiRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "T20-all-rounder",
			description = "ICC men's t20 ranking for all-rounder."
			)
	@GetMapping(path = "/men/all-rounder/t20")
	public ResponseEntity<List<PlayerRankingDto>> menAllRounderT20Ranking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenAllRoundersT20Rankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}

}
