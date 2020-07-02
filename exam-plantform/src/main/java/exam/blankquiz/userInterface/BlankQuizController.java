package exam.blankquiz.userInterface;

import exam.blankquiz.application.AddBlankQuizCommand;
import exam.blankquiz.application.BlankQuizApplicationService;
import exam.blankquiz.application.DeleteBlankQuizCommand;
import exam.blankquiz.application.UpdateBlankQuizCommand;
import exam.blankquiz.domain.model.BlankQuiz;
import exam.blankquiz.infrastructure.MemoryBlankQuizReadRepository;
import exam.blankquiz.domain.model.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;
    private MemoryBlankQuizReadRepository paperReadRepository;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService, MemoryBlankQuizReadRepository paperReadRepository) {
        this.blankQuizApplicationService = blankQuizApplicationService;
        this.paperReadRepository = paperReadRepository;
    }

    @PostMapping("/{quizBankId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDto add(@RequestBody AddBlankQuizCommand command, @PathVariable String quizBankId) {
        command.setQuizBankId(quizBankId);
        final BlankQuizId blankQuizId = blankQuizApplicationService.add(command);
        return BlankQuizDto.from(blankQuizId);
    }

    @PutMapping("/{quizBankId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDto update(@RequestBody UpdateBlankQuizCommand command, @PathVariable String quizBankId) {
        command.setQuizBankId(quizBankId);
        final BlankQuizId blankQuizId = blankQuizApplicationService.update(command);
        return BlankQuizDto.from(blankQuizId);
    }

    @DeleteMapping("/{quizBankId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    BlankQuizDto delete(@RequestBody DeleteBlankQuizCommand command, @PathVariable String quizBankId) {
        command.setQuizBankId(quizBankId);
        final BlankQuizId blankQuizId = blankQuizApplicationService.delete(command);
        return BlankQuizDto.from(blankQuizId);
    }

    @GetMapping("/{blankQuizId}")
    BlankQuiz get(@PathVariable String blankQuizId) {
        return paperReadRepository.getByQuizBankId(blankQuizId);
    }
}
