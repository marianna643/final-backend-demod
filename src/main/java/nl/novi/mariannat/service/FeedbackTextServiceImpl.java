package nl.novi.mariannat.service;

import nl.novi.mariannat.domain.FeedbackText;
import nl.novi.mariannat.exception.DatabaseErrorException;
import nl.novi.mariannat.exception.RecordNotFoundException;
import nl.novi.mariannat.repository.FeedbackTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackTextServiceImpl implements FeedbackTextService {

    @Autowired
    FeedbackTextRepository feedbackTextRepository;

    @Override
    public List<FeedbackText> getAllFeedbackTexts() {
        return feedbackTextRepository.findAll();
    }

    @Override
    public FeedbackText getFeedbackTextById(long id) {
        if (feedbackTextRepository.existsById(id)) {
            return feedbackTextRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteFeedbackText(long id) {
        if (feedbackTextRepository.existsById(id)) {
            feedbackTextRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveFeedbackText(FeedbackText feedbackText) {
        FeedbackText newFeedbackText = feedbackTextRepository.save(feedbackText);
        return newFeedbackText.getId();
    }

    @Override
    public void updateFeedbackText(long id, FeedbackText feedbackText) {
        if (feedbackTextRepository.existsById(id)) {
            try {
                FeedbackText existingFeedbackText = feedbackTextRepository.findById(id).orElse(null);
                existingFeedbackText.setMessage(feedbackText.getMessage());
                feedbackTextRepository.save(existingFeedbackText);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }
}
