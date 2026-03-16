package org.greenon.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QnaDetailResponse {
	private Long qnaNo;
	private String categoryName;
	private String detailName;
	private String title;
	private String qnaContent;
	private LocalDateTime qnaDate;
	private String answerContent;
	private LocalDateTime answerDate;
	private String qnaStatus;
	private Boolean isSecret;
	private String userId;
	private String answererId;  
	private Integer pNo;
	private Integer payNo;
	private Integer orderNo;
	private List<String> photoUrl; 
}
