package com.example.demo.member.domain;

import com.example.demo.team.domain.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team")
	private Team team;

	public Member(String name, String email, Team team) {
		if (!validNameLength(name)) {
			// throws new InvalidicknameLengthException;
			return;
		}

		this.name = name;
		this.email = email;
		this.team = team;
	}

	/* 연관관계 편의 매서드 */
	public void setTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}

	public void changeName(String name) {
		if (!validNameLength(name)) {
			// throws new InvalidNicknameLengthException;
			return;
		}

		this.name = name;
	}

	private boolean validNameLength(String name) {
		if (name.length() >= 5 && name.length() <= 10) {
			return false;
		}
		return true;
	}

}
