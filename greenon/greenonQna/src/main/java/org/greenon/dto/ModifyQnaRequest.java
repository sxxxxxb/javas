package org.greenon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyQnaRequest {
	private String title;
	private String qnaContent;
	private boolean isSecret;
}
