package com.ssafy.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dao.MatchDao;
import com.ssafy.mvc.dto.Match;
import com.ssafy.mvc.dto.SearchCondition;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchDao dao;

	@Override
	public boolean insertMatch(Match match) {
		return dao.insertMatch(match) > 0;
	}

	@Override
	public boolean updateMatch(Match match) {
		return dao.updateMatch(match)>0;
	}

	@Override
	public boolean deleteMatch(int id) {
		return dao.deleteMatch(id)>0;
	}

	@Override
	public List<Match> searchByCondition(String region) {
		return dao.searchByCondition(region);
	}

	@Override
	public Match selectOne(int id) {
		return dao.selectOne(id);
	}

	@Override
	public List<Match> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Match> selectcanList() {
		return dao.selectcanList();
	}

	@Override
	public List<Match> selectStadiumMatch(int id) {
		return dao.selectStadiumMatch(id);

	}

	@Override
	public String matchAvgTier(int matchId) {
		return dao.matchAvgTier(matchId);
	}

	@Override
	public List<Match> selectStadiumDayMatch(int id, String date1, String date2) {
		return dao.selectStadiumDayMatch(id, date1, date2);
	}

	@Override
	public List<Match> RecommandMatchList(String district, String province) {
		return dao.RecommandMatchList(district, province);
	}

	@Override
	public List<Match> getMatchManagerList(int id) {
		return dao.getMatchManagerList(id);
	}
	
	

}
