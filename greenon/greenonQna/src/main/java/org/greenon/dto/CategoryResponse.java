package org.greenon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryResponse {
	private Integer qnaDetailNo;
	private String detailName;
	private Integer qnaCategoryNo;
	private String categoryName;
}
