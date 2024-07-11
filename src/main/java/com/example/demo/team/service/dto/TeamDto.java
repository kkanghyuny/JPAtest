package com.example.demo.team.service.dto;

import java.util.List;

import com.example.demo.member.domain.Member;
import com.example.demo.team.domain.Team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto {
	private Long id;
	private String name;
	private List<Member> members;

	public TeamDto(Team team) {
		this.id = team.getId();
		this.name = team.getName();
		this.members = team.getMembers();
	}
}
