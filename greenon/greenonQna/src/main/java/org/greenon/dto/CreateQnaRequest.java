package org.greenon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateQnaRequest {
	private String title;
	private String qnaContent;
	private boolean isSecret;
	private Integer pNo;
	private Integer payNo;
	private Integer orderNo;
	private Integer qnaDetailNo;
}
