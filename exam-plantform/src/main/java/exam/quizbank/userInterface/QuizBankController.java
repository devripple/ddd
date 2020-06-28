package exam.quizbank.userInterface;

import exam.quizbank.application.MaintainQuizBankCommand;
import exam.quizbank.domain.model.QuizBank;
import exam.quizbank.domain.model.QuizBankId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import exam.quizbank.application.QuizBankApplicationService;
import exam.quizbank.infrastructure.MemoryQuizBankReadRepository;

@RestController
public class QuizBankController {

    private QuizBankApplicationService quizBankApplicationService;
    private MemoryQuizBankReadRepository paperReadRepository;

    @Autowired
    public QuizBankController(QuizBankApplicationService quizBankApplicationService, MemoryQuizBankReadRepository paperReadRepository) {
        this.quizBankApplicationService = quizBankApplicationService;
        this.paperReadRepository = paperReadRepository;
    }

    @PostMapping("/maintain")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    QuizBankDTO maintain(@RequestBody MaintainQuizBankCommand command) {
        final QuizBankId paperId = quizBankApplicationService.maintain(command);
        return QuizBankDTO.from(paperId);
    }

    @GetMapping("/{quizBankId}")
    QuizBank get(@PathVariable String quizBankId) {
        return paperReadRepository.getByQuizBankId(quizBankId);
    }
}
