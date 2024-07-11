package com.example.demo.member.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.controller.request.MemberReq;
import com.example.demo.member.controller.request.PutMemberReq;
import com.example.demo.member.domain.Member;
import com.example.demo.member.exception.EmailAlreadyExistsException;
import com.example.demo.member.exception.InvalidEmailFormatException;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.team.domain.Team;
import com.example.demo.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	private final Pattern emailPattern = Pattern.compile(
		"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
		Pattern.CASE_INSENSITIVE
	);

	@Transactional
	public Member createMember(MemberReq req) {
		validateEmail(req.getEmail());
		if(memberRepository.existsByEmail(req.getEmail())){
			throw new EmailAlreadyExistsException();
		}

		Team team = teamRepository.findById(req.getTeamId())
			.orElseThrow(() -> new IllegalArgumentException("Invalid teamId"));

		Member member = new Member(req.getName(), req.getEmail(), team);
		memberRepository.save(member);

		return member;
	}

	@Transactional
	public Member updateMember(Long id, PutMemberReq req){
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid memberId"));

		member.changeName(req.getName());
		return member;
	}

	private void validateEmail(String email) {
		if (!emailPattern.matcher(email).matches()) {
			throw new InvalidEmailFormatException();
		}
	}
}
