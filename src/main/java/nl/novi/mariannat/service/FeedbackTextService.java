package nl.novi.mariannat.service;

import nl.novi.mariannat.domain.FeedbackText;

import java.util.List;

public interface FeedbackTextService {

    List<FeedbackText> getAllFeedbackTexts();

    FeedbackText getFeedbackTextById(long id);

    void deleteFeedbackText(long id);

    long saveFeedbackText(FeedbackText feedbackText);

    void updateFeedbackText(long id, FeedbackText feedbackText);
}
