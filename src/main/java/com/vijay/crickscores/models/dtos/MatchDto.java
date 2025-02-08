package com.shashwat.crickscores.models.dtos;

import java.time.LocalDate;

import com.shashwat.crickscores.models.MatchStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MatchDto {
	
	private String teamsPlaying;
	
	private String matchNumber;
	
	private String battingTeam;
	
	private String battingTeamScore;
	
	private String bowlingTeam;
	
	private String bowlingTeamScore;
	
	private String textLive;
	
	private String textComplete;
	
	private String matchLink;
	
	private LocalDate matchDate;
	
	private MatchStatus status;
	
	public void setMatchStatus() {
		if(this.textComplete.trim().isBlank()) this.status = MatchStatus.LIVE;
		else {
			this.status = MatchStatus.COMPLETED;
		}
	}
	
}
