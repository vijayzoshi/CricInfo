package com.shashwat.crickscores.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shashwat.crickscores.models.dtos.ResultDto;
import com.shashwat.crickscores.models.dtos.ScheduleDto;
import com.shashwat.crickscores.services.TeamIndiaService;

@Service
public class TeamIndiaServiceImpl implements TeamIndiaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeamIndiaServiceImpl.class);

	@Override
	public List<ScheduleDto> getScheduleForTeamIndia() {
		// TODO Auto-generated method stub
		List<ScheduleDto> scheduleList = new ArrayList<>();
		
		try {
			String url = "https://www.cricbuzz.com/cricket-team/india/2/schedule";
			Document document = Jsoup.connect(url).get();
			Elements matchesScheduled = document.select("div.cb-series-matches");
			
			for(Element game : matchesScheduled) {
				
				String matchTitleString = game.select("a.text-hvr-underline > span").text();
				String tourNameString = game.select("a.text-hvr-underline + div").text();
				String matchVenueString = game.select("a.text-hvr-underline + div +div").text();
				String matchStatusString = game.select("a.text-hvr-underline + div +div + a").text();
				String matchTimeString = game.select("div.cb-srs-mtchs-tm + div").text();
				
				/*
				LOGGER.info(matchTitleString);
				LOGGER.info(tourNameString);
				LOGGER.info(matchVenueString);
				LOGGER.info(matchStatusString);
				LOGGER.info(matchTimeString);
				*/
				
				ScheduleDto scheduleDto = ScheduleDto.builder()
						.matchTitle(matchTitleString)
						.tourName(tourNameString)
						.matchVenue(matchVenueString)
						.matchStatus(matchStatusString)
						.matchTime(matchTimeString)
						.build();
				
				scheduleList.add(scheduleDto);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return scheduleList;
	}

	@Override
	public List<ResultDto> getResultsTeamIndia() {
		// TODO Auto-generated method stub
		
		List<ResultDto> resultList = new ArrayList<>();
		
		try {
			
			String url = "https://www.cricbuzz.com/cricket-team/india/2/results";
			Document document = Jsoup.connect(url).get();
			
			Elements elements = document.select("div.cb-brdr-thin-btm");
			
			for(Element element : elements) {
				
				String matchTitleString = element.select("a.text-hvr-underline > span").text();
				String tourNameString = element.select("a.text-hvr-underline + div").text();
				String matchVenueString = element.select("a.text-hvr-underline + div +div").text();
				String matchStatusString = element.select("a.text-hvr-underline + div +div + a").text();
				
				ResultDto resultDto = ResultDto.builder()
						.matchTitle(matchTitleString)
						.tourName(tourNameString)
						.matchVenue(matchVenueString)
						.matchStatus(matchStatusString)
						.build();
				
				resultList.add(resultDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultList;
	}

}
