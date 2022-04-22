package ma.stibits.pos.controller;

import ma.stibits.pos.model.bo.Category;
import ma.stibits.pos.model.bo.Review;
import ma.stibits.pos.service.Implementation.CategoryService;
import ma.stibits.pos.service.Implementation.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review c)
    {
        Review r=reviewService.saveReview(c);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> listReview() {
        List<Review> lst=reviewService.listReview();
        return new ResponseEntity<>(lst,HttpStatus.OK);}

    @GetMapping(path="/getOne/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") Long idCat) {
        Review r=reviewService.getReview(idCat);
        return new ResponseEntity<>(r,HttpStatus.OK);
    }
}
