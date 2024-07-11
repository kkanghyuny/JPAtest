package com.example.demo.team.controller.response;

import java.util.List;

import com.example.demo.team.domain.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetAllTeamRes {
	private String code;

	private String timestamp;

	private String message;

	private List<Team> data;
}
