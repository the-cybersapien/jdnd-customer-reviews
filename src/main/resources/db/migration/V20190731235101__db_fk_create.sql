ALTER TABLE review
    ADD CONSTRAINT review_product_id_fk FOREIGN KEY (product_id) references product (id);

ALTER TABLE comment
    ADD CONSTRAINT comment_review_id_fk FOREIGN KEY (review_id) references review (id);

