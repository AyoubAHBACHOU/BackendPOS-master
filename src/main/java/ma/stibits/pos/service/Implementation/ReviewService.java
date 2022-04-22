package ma.stibits.pos.service.Implementation;

import ma.stibits.pos.model.bo.Review;
import ma.stibits.pos.model.dao.ReviewRepository;
import ma.stibits.pos.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ReviewService implements IReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review cat) {
        return reviewRepository.save(cat);
    }

    @Override
    public List<Review> listReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepository.findById(id).get();
    }
}
