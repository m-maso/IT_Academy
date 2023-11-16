
DROP DATABASE IF EXISTS youtube;
CREATE DATABASE youtube CHARACTER SET utf8mb4;
USE youtube;

CREATE TABLE user(
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(20) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender ENUM('Woman','Man'),
    postcode VARCHAR(10),
    country VARCHAR(25),
    PRIMARY KEY(user_id)
);

CREATE TABLE video(
    video_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT(350),
    size FLOAT NOT NULL,
    filename VARCHAR(45) NOT NULL,
    length FLOAT NOT NULL,
    thumbnail BLOB,
    num_reproductions INT,
    num_likes INT,
    num_dislikes INT,
    state ENUM('public','hidden','private') NOT NULL,
    date_hour_published DATETIME NOT NULL,
    fk_publishedby_user_id INT NOT NULL,
    PRIMARY KEY(video_id),
    FOREIGN KEY(fk_publishedby_user_id) REFERENCES user(user_id)
);

CREATE TABLE tag(
    tag_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    fk_video_id INT NOT NULL,
    PRIMARY KEY(tag_id),
    FOREIGN KEY(fk_video_id) REFERENCES video(video_id) 
);

CREATE TABLE channel(
    channel_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description TEXT(350),
    creation_date DATE NOT NULL,
    fk_createdby_user_id INT NOT NULL,
    PRIMARY KEY(channel_id),
    FOREIGN KEY(fk_createdby_user_id) REFERENCES user(user_id)
);

CREATE TABLE subscribe_channel(
    user_user_id INT NOT NULL,
    channel_channel_id INT NOT NULL,
    PRIMARY KEY(user_user_id, channel_channel_id),
    FOREIGN KEY(user_user_id) REFERENCES user(user_id),
    FOREIGN KEY(channel_channel_id) REFERENCES channel(channel_id)
);

CREATE TABLE rate_video(
    user_user_id INT NOT NULL,
    video_video_id INT NOT NULL,
    date_time_rating DATETIME NOT NULL,
    likes VARCHAR(10),
    dislike VARCHAR(10),
    PRIMARY KEY(user_user_id, video_video_id),
    FOREIGN KEY(user_user_id) REFERENCES user(user_id),
    FOREIGN KEY(video_video_id) REFERENCES video(video_id)
);

CREATE TABLE playlist(
    playlist_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    creation_date DATE NOT NULL,
    state ENUM('public','private') NOT NULL,
    fk_createdby_user_id INT NOT NULL,
    fk_added_video_id INT NOT NULL,
    PRIMARY KEY(playlist_id),
    FOREIGN KEY(fk_createdby_user_id) REFERENCES user(user_id),
    FOREIGN KEY(fk_added_video_id) REFERENCES video(video_id)
);

CREATE TABLE comment(
    comment_id INT NOT NULL AUTO_INCREMENT,
    comment_text TEXT(350) NOT NULL,
    date_hour DATETIME NOT NULL,
    PRIMARY KEY(comment_id),
    fk_user_id INT NOT NULL,
    FOREIGN KEY(fk_user_id) REFERENCES user(user_id)   
);

CREATE TABLE rate_comment(
    ratedby_user_id INT NOT NULL,
    comment_comment_id INT NOT NULL,
    date_hour DATETIME NOT NULL,
    likes VARCHAR(10),
    dislike VARCHAR(10),
    PRIMARY KEY(ratedby_user_id, comment_comment_id),
    FOREIGN KEY(ratedby_user_id) REFERENCES user(user_id),
    FOREIGN KEY(comment_comment_id) REFERENCES comment(comment_id)
);
