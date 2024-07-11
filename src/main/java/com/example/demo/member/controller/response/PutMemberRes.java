package com.example.demo.member.controller.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PutMemberRes {
	private String code;

	private String timestamp;

	private String message;

	private String data;
}
