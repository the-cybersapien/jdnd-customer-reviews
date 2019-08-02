package xyz.cybersapien.tech.reviews.utils;

import xyz.cybersapien.tech.reviews.entity.Comment;
import xyz.cybersapien.tech.reviews.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public final class CommentUtils {

    // Make this constructor private to ensure that this class can't be initialized
    private CommentUtils() {
    }

    public static Comment findProductById(CommentRepository commentRepository, Integer commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        if (optionalComment.isPresent())
            return optionalComment.get();

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, String.format("Comment with ID %d Not Found", commentId)
        );
    }
}
