package com.shashwat.crickscores.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerRankingDto {

	private String position;
	
	private String playerName;
	
	private String team;
	
	private String role;
	
	private String rating;

}
