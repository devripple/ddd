package exam.quizbank.domain.service;

import java.util.List;

public interface BlankQuizClient {
    List<BlankQuizDto> getBlankQuizzesByIds(List<String> blankQuizIds);
}

