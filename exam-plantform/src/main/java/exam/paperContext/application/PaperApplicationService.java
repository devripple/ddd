package exam.paperContext.application;

import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperRepository;
import exam.paperContext.domain.service.BlankQuizClient;
import exam.paperContext.domain.service.BlankQuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PaperApplicationService {
    private PaperRepository paperRepository;
    private BlankQuizClient blankQuizClient;

    private List<BlankQuizDto> getBlankQuizzesByIds(List<String> blankQuizIds) {
        return blankQuizClient.getBlankQuizzesByIds(blankQuizIds);
    }

    @Autowired
    public PaperApplicationService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public PaperId assemblePaper(AssemblePaperCommand command) {
        List<BlankQuizDto> blankQuizDtos = blankQuizFrom(command);
        final String teacherId = command.getTeacherId();
        final PaperId paperId = paperRepository.nextPaperId();

        final Paper paper = Paper.assemble(paperId, teacherId, blankQuizDtos.stream()
                .map(BlankQuizDto::toBlankQuiz)
                .collect(toList()));
        paperRepository.save(paper);

        return paperId;
    }

    public List<Paper> getAll() {
        return paperRepository.getAll();
    }

    public PaperId reassemblePaper(String paperId, AssemblePaperCommand command) {
        final Paper paper = paperRepository.find(new PaperId(paperId));
        List<BlankQuizDto> blankQuizDtos = blankQuizFrom(command);
        final String teacherId = command.getTeacherId();

        paper.reassemble(teacherId, blankQuizDtos.stream()
                .map(BlankQuizDto::toBlankQuiz)
                .collect(toList()));

        return paper.getPaperId();
    }

    private List<BlankQuizDto> blankQuizFrom(AssemblePaperCommand command) {
        return command.getQuizzes().stream().map(quiz -> new BlankQuizDto(quiz.getQuizBankId(),
                quiz.getScore())).collect(toList());
    }
}
