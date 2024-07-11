package com.example.demo.team.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.team.controller.response.GetAllTeamRes;
import com.example.demo.team.controller.response.GetTeamRes;
import com.example.demo.team.domain.Team;
import com.example.demo.team.service.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

	private final TeamService teamService;

	@GetMapping
	public ResponseEntity<GetAllTeamRes> getAllTeams() {
		List<Team> teams = teamService.getAllTeams();

		GetAllTeamRes res = new GetAllTeamRes("2000", LocalDateTime.now().toString(), "OK", teams);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/{teamId}")
	public ResponseEntity<?> getTeamById(@PathVariable Long teamId) {
		Team team = teamService.getTeamById(teamId);

		GetTeamRes res = new GetTeamRes("2000", LocalDateTime.now().toString(), "OK", team);
		return ResponseEntity.ok(res);
	}
}