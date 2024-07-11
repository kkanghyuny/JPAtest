package com.example.demo.member.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.controller.request.MemberReq;
import com.example.demo.member.controller.request.PutMemberReq;
import com.example.demo.member.controller.response.MemberRes;
import com.example.demo.member.controller.response.PutMemberRes;
import com.example.demo.member.domain.Member;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.dto.MemberDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final ObjectMapper mapper;

	@PostMapping
	public ResponseEntity<MemberRes> createMember(@RequestBody MemberReq req) throws JsonProcessingException {
		Member member = memberService.createMember(req);

		// MemberDto dto = new MemberDto(member);
		// String memberJson = mapper.writeValueAsString(dto);

		MemberRes res = new MemberRes("2000", LocalDateTime.now().toString(), "OK", member);
		System.out.println(res);
		return ResponseEntity.ok(res);
	}

	@PutMapping("/{memberId}")
	public ResponseEntity<PutMemberRes> updateMember(@PathVariable Long memberId, @RequestBody PutMemberReq req) throws
		JsonProcessingException {
		Member member = memberService.updateMember(memberId, req);

		MemberDto dto = new MemberDto(member);
		String memberJson = mapper.writeValueAsString(dto);

		PutMemberRes res = new PutMemberRes("2000", LocalDateTime.now().toString(), "OK", memberJson);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
