package com.shashwat.crickscores.services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.shashwat.crickscores.models.MatchStatus;
import com.shashwat.crickscores.models.dtos.MatchDto;
import com.shashwat.crickscores.services.MatchService;

@Service
public class MatchServiceImpl implements MatchService{
	
	private List<MatchDto> scrapeData() {

		List<MatchDto> allMatchList = new ArrayList<>();
		
		try {
			String url = "https://www.cricbuzz.com/cricket-match/live-scores";
			Document document = Jsoup.connect(url).get();
			
			Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-tms-itm");
			
			for(Element element : liveScoreElements) {
				
				String teamsPlayingString = element.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
				String matchNumberVenueString = element.select("span.text-gray").text();
				
				Elements battingElement = element.select("div.cb-hmscg-bat-txt");
				String battingTeamString = battingElement.select("div.cb-hmscg-tm-nm").text();
				String battingTeamScoreString = battingElement.select("div.cb-hmscg-tm-nm+div").text();
				
				Elements bowlingElement = element.select("div.cb-hmscg-bwl-txt");
				String bowlingTeamString = bowlingElement.select("div.cb-hmscg-tm-nm").text();
				String bowlingTeamScoreString = bowlingElement.select("div.cb-hmscg-tm-nm+div").text();
				
				String textLiveString = element.select("div.cb-text-live").text();
				String textCompleteString = element.select("div.cb-text-complete").text();
				
				String matchLinkString = url.substring(0, 24) + element.select("h3.cb-lv-scr-mtch-hdr > a").attr("href").toString();
				
				MatchDto match = MatchDto.builder()
						.teamsPlaying(teamsPlayingString)
						.matchNumber(matchNumberVenueString)
						.battingTeam(battingTeamString)
						.battingTeamScore(battingTeamScoreString)
						.bowlingTeam(bowlingTeamString)
						.bowlingTeamScore(bowlingTeamScoreString)
						.textLive(textLiveString)
						.textComplete(textCompleteString)
						.matchLink(matchLinkString)
						.matchDate(LocalDate.now())
						.build();
				
				match.setMatchStatus();
				
				allMatchList.add(match);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allMatchList;
		
	}

	@Override
	public List<MatchDto> getLiveMatches() {
		// TODO Auto-generated method stub
		return this.scrapeData().stream()
				.filter(m -> m.getStatus().equals(MatchStatus.LIVE))
				.toList();
	}

	@Override
	public List<MatchDto> getCompletedMatches() {
		// TODO Auto-generated method stub
		return this.scrapeData().stream()
				.filter(m -> m.getStatus().equals(MatchStatus.COMPLETED))
				.toList();
	}

	@Override
	public List<MatchDto> getAllMatches() {
		// TODO Auto-generated method stub
		return this.scrapeData();
	}

}
