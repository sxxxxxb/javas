package org.greenon.controller;

import lombok.RequiredArgsConstructor;

import org.greenon.dto.CategoryResponse;
import org.greenon.dto.QnaListResponse;
import org.greenon.service.QnaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qnas")
@RequiredArgsConstructor
public class QnaController {

    private final QnaService qnaService;

    @GetMapping
    public ResponseEntity<List<QnaListResponse>> getQnaListByProduct(
            @RequestParam Integer productId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        List<QnaListResponse> response = qnaService.getQnaListByProduct(productId, page, size);
        return ResponseEntity.ok(response);
    }

    // 2. 카테고리 목록 조회
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        List<CategoryResponse> response = qnaService.getCategories();
        return ResponseEntity.ok(response);
    }
}