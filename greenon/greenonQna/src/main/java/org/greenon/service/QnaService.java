package org.greenon.service;
import lombok.RequiredArgsConstructor;
import org.greenon.dto.AnswerQnaRequest;
import org.greenon.dto.CategoryResponse;
import org.greenon.dto.CreateQnaRequest;
import org.greenon.dto.ModifyQnaRequest;
import org.greenon.dto.QnaListResponse;
import org.greenon.repository.QnaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaMapper qnaMapper;

    @Transactional(readOnly = true)
    public List<QnaListResponse> getQnaListByProduct(Integer productId, int page, int size) {
        int offset = (page - 1) * size; // 페이징 계산식
        return qnaMapper.selectQnaListByProduct(productId, size, offset);
    }

    @Transactional
    public void createQna(CreateQnaRequest request, String userId) {
        if (request.getPNo() == null || request.getQnaDetailNo() == null) {
            throw new IllegalArgumentException("상품 번호와 문의 유형은 필수입니다.");
        }
        
        qnaMapper.insertQna(request, userId);
    }

    @Transactional(readOnly = true)
    public List<QnaListResponse> getMyQnaList(String userId, int page, int size) {
        int offset = (page - 1) * size;
        return qnaMapper.selectMyQnaList(userId, size, offset);
    }

    @Transactional
    public void updateQna(Long qnaNo, ModifyQnaRequest request, String userId) {
        int updatedRow = qnaMapper.updateQna(qnaNo, request, userId);
        
        if (updatedRow == 0) {
            throw new IllegalArgumentException("수정할 수 없는 상태(이미 답변 완료)이거나 권한이 없습니다.");
        }
    }

    @Transactional
    public void deleteQna(Long qnaNo, String userId) {
        qnaMapper.deleteQnaPhoto(qnaNo); 
        int updatedRow = qnaMapper.deleteQna(qnaNo, userId);
        if (updatedRow == 0) {
            throw new IllegalArgumentException("삭제할 수 없는 상태이거나 권한이 없습니다.");
        }
    }

    @Transactional
    public void createAnswer(Long qnaNo, AnswerQnaRequest request, String sellerId) {
        int updatedRow = qnaMapper.updateAnswer(qnaNo, request.getQnaContent(), sellerId);
        
        if (updatedRow == 0) {
            throw new IllegalArgumentException("존재하지 않는 문의글이거나 권한이 없습니다.");
        }
    }
    @Transactional(readOnly = true)
    public List<CategoryResponse> getCategories() {
        return qnaMapper.selectCategories();
    }
    
}