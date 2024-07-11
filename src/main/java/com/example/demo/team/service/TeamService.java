package com.example.demo.team.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.team.domain.Team;
import com.example.demo.team.repository.TeamRepository;

@Service
public class TeamService {

	private TeamRepository teamRepository;

	@Transactional
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	@Transactional
	public Team getTeamById(Long teamId) {
		return teamRepository.findById(teamId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid team ID"));
	}
}