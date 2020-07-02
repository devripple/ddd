package exam.blankquiz.application;

import exam.blankquiz.domain.model.BlankQuiz;
import exam.blankquiz.domain.model.BlankQuizId;
import exam.blankquiz.domain.model.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlankQuizApplicationService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId add(AddBlankQuizCommand command) {
        BlankQuiz blankQuiz = new BlankQuiz();
        blankQuiz.setQuizBankId(command.getQuizBankId());
        blankQuiz.setBlankQuizId(blankQuizRepository.nextId());
        blankQuiz.setContent(command.getContent());
        blankQuiz.setReferenceAnswer(command.getReferenceAnswer());
        blankQuiz.setScore(command.getScore());
        blankQuiz.setTeacherId(command.getTeacherId());
        blankQuiz.setCreateTime(LocalDateTime.now());

        blankQuizRepository.save(blankQuiz);
        return blankQuiz.getBlankQuizId();
    }

    public BlankQuizId update(UpdateBlankQuizCommand command) {
        BlankQuiz blankQuiz = new BlankQuiz();
        blankQuiz.setQuizBankId(command.getQuizBankId());
        blankQuiz.setBlankQuizId(command.getBlankQuizId());
        blankQuiz.setContent(command.getContent());
        blankQuiz.setReferenceAnswer(command.getReferenceAnswer());
        blankQuiz.setScore(command.getScore());
        blankQuiz.setTeacherId(command.getTeacherId());
        blankQuiz.setUpdateTime(LocalDateTime.now());
        blankQuizRepository.save(blankQuiz);
        return blankQuiz.getBlankQuizId();
    }

    public BlankQuizId delete(DeleteBlankQuizCommand command) {
        BlankQuiz blankQuiz = new BlankQuiz();
        blankQuiz.setQuizBankId(command.getQuizBankId());
        blankQuiz.setBlankQuizId(command.getBlankQuizId());
        blankQuiz.setDeleteTime(LocalDateTime.now());
        blankQuiz.setDeleted(true);
        blankQuizRepository.save(blankQuiz);
        return blankQuiz.getBlankQuizId();
    }

    public BlankQuiz get(BlankQuizId blankQuizId) {
        return blankQuizRepository.find(blankQuizId);
    }


}
