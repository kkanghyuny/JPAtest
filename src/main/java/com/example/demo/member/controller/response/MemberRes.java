package com.example.demo.member.controller.response;

import com.example.demo.member.domain.Member;

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
public class MemberRes {
	private String code;

	private String timestamp;

	private String message;

	private Member data;
}
