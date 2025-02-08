package com.shashwat.crickscores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.dtos.ResultDto;
import com.shashwat.crickscores.models.dtos.ScheduleDto;
import com.shashwat.crickscores.services.TeamIndiaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/crickscores")
@Tag(name = "Team India Module", description = "Get the schedule and results for Team India.")
public class TeamIndiaController {

	private TeamIndiaService teamIndiaService;
	
	public TeamIndiaController(TeamIndiaService tis) {
		this.teamIndiaService = tis;
	}
	
	@Operation(
			summary = "Schedule",
			description = "get the schedule planned for team India."
			)
	@GetMapping(path = "/ind-schedule")
	public ResponseEntity<List<ScheduleDto>> getSchedule(){
		List<ScheduleDto> list = this.teamIndiaService.getScheduleForTeamIndia();
		return new ResponseEntity<List<ScheduleDto>>(list, HttpStatus.OK);
	}
	
	@Operation(
			summary = "Results",
			description = "get the results of the past matches played by team India."
			)
	@GetMapping(path = "/ind-results")
	public ResponseEntity<List<ResultDto>> getResults(){
		List<ResultDto> list = this.teamIndiaService.getResultsTeamIndia();
		return new ResponseEntity<List<ResultDto>>(list, HttpStatus.OK);
	}
}
