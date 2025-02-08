package com.shashwat.crickscores.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDto {

	private String matchTitle;
	
	private String tourName;
	
	private String matchVenue;
	
	private String matchStatus;
	
}
