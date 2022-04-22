package ma.stibits.pos.service;

import ma.stibits.pos.model.bo.Review;

import java.util.List;

public interface IReviewService {
    public Review saveReview(Review cat);
    public List<Review> listReview();
    Review getReview(Long id);

}
