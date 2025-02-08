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

import com.shashwat.crickscores.models.MatchFormat;
import com.shashwat.crickscores.models.dtos.PlayerRankingDto;
import com.shashwat.crickscores.services.RankingsService;

@Service
public class RankingsServiceImpl implements RankingsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RankingsServiceImpl.class);
	
	private List<PlayerRankingDto> generateRankingList(Elements elements, String role){
		
		List<PlayerRankingDto> list = new ArrayList<>();
		for(Element e : elements) {
			String positionString = e.child(0).text();
			String ratingString = e.child(2).text();
			String playerNameString = e.select("a").text();
			String teamNameString = e.select("a+div").text();
			
			PlayerRankingDto player = PlayerRankingDto.builder()
					.position(positionString)
					.playerName(playerNameString)
					.team(teamNameString)
					.role(role)
					.rating(ratingString)
					.build();
			
			list.add(player);
		}
		
		return list;
	}
	
	private List<PlayerRankingDto> scrapeRankings(MatchFormat format, String role) {
		try {

			StringBuilder urlBuilder = new StringBuilder("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/");
			urlBuilder.append(role);
			Document document = Jsoup.connect(urlBuilder.toString()).get();
			Elements elements = document.select("div.cb-plyr-tbody > div");
			
			Elements testElements = elements.get(0).select("div.cb-lst-itm");
			Elements odiElements = elements.get(1).select("div.cb-lst-itm");
			Elements t20eElements = elements.get(2).select("div.cb-lst-itm");
			
			if(format.equals(MatchFormat.TEST)) return generateRankingList(testElements, role);
			else if(format.equals(MatchFormat.ODI)) return generateRankingList(odiElements, role);
			return generateRankingList(t20eElements, role);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PlayerRankingDto> getMenBattingTestRankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.TEST, "batting");
	}

	@Override
	public List<PlayerRankingDto> getMenBattingOdiRankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.ODI, "batting");
	}

	@Override
	public List<PlayerRankingDto> getMenBattingT20Rankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.T20, "batting");
	}

	@Override
	public List<PlayerRankingDto> getMenBowlingTestRankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.TEST, "bowling");
	}

	@Override
	public List<PlayerRankingDto> getMenBowlingOdiRankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.ODI, "bowling");
	}

	@Override
	public List<PlayerRankingDto> getMenBowlingT20Rankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.T20, "bowling");
	}

	@Override
	public List<PlayerRankingDto> getMenAllRoundersTestRankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.TEST, "all-rounder");
	}

	@Override
	public List<PlayerRankingDto> getMenAllRoundersOdiRankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.ODI, "all-rounder");
	}

	@Override
	public List<PlayerRankingDto> getMenAllRoundersT20Rankings() {
		// TODO Auto-generated method stub
		return scrapeRankings(MatchFormat.T20, "all-rounder");
	}

}
