package com.example.demo.member.service.dto;

import com.example.demo.member.domain.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
	private Long id;
	private Long teamId;
	private String name;
	private String email;

	public MemberDto(Member member) {
		this.id = member.getId();
		this.teamId = member.getTeam().getId();
		this.name = member.getName();
		this.email = member.getEmail();
	}
}
