-- entity.product
CREATE TABLE product
(
    id          int auto_increment primary key,
    name        varchar(255)  not null,
    description varchar(1000) not null
);

-- entity.review
CREATE TABLE review
(
    id          int auto_increment primary key,
    title       varchar(255)                        not null,
    review_text varchar(10000)                      null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    recommended boolean                             null,
    product_id  int                                 not null
);

-- entity.comment
CREATE TABLE comment
(
    id           int auto_increment primary key,
    title        varchar(255)                        not null,
    comment_text varchar(5000)                       not null,
    review_id    int                                 not null,
    created_at   timestamp default CURRENT_TIMESTAMP null
);

