package com.example.demo.team.controller.response;

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
public class GetTeamRes {
	private String code;

	private String timestamp;

	private String message;

	private Team data;
}
