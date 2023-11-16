
DROP DATABASE IF EXISTS spotify;
CREATE DATABASE spotify CHARACTER SET utf8mb4;
USE spotify;

CREATE TABLE user(
    user_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(20) NOT NULL,
    username VARCHAR(45) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Woman','Man'),
    country VARCHAR(30),
    postcode VARCHAR(10),
    user_type ENUM('free','premium') NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE premium_user_suscription(
    suscription_id INT NOT NULL AUTO_INCREMENT,
    start_date DATE NOT NULL,
    renovation_date DATE,
    payment_method ENUM('credit card','paypal') NOT NULL,
    fk_user_id INT NOT NULL,
    PRIMARY KEY(suscription_id),
    FOREIGN KEY(fk_user_id) REFERENCES user(user_id)
);

CREATE TABLE user_payment(
    user_payment_id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    order_number INT NOT NULL UNIQUE, 
    total INT NOT NULL,
    fk_payed_subscription_id INT NOT NULL,
    PRIMARY KEY(user_payment_id),
    FOREIGN KEY(fk_payed_subscription_id) REFERENCES premium_user_suscription(suscription_id)
);

CREATE TABLE credit_card(
    credit_card_id INT NOT NULL AUTO_INCREMENT,
    card_number INT NOT NULL,
    expiration_date VARCHAR(45) NOT NULL,
    CVV_code INT NOT NULL,
    fk_subscription_id INT NOT NULL,
    PRIMARY KEY(credit_card_id),
    FOREIGN KEY(fk_subscription_id) REFERENCES premium_user_suscription(suscription_id)
);

CREATE TABLE paypal(
    paypal_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    fk_subscription_id INT NOT NULL,
    PRIMARY KEY(paypal_id),
    FOREIGN KEY(fk_subscription_id) REFERENCES premium_user_suscription(suscription_id)
);

CREATE TABLE playlist(
    playlist_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    total_songs_num INT NOT NULL,
    playlist_type ENUM('active', 'deleted') NOT NULL,
    creation_date DATE NOT NULL,
    deletion_date DATE,
    fk_createdby_user_id INT NOT NULL,
    PRIMARY KEY(playlist_id),
    FOREIGN KEY(fk_createdby_user_id) REFERENCES user(user_id)
);

CREATE TABLE artist(
    artist_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    portrait BLOB,
    fk_related_artist INT NOT NULL,
    PRIMARY KEY(artist_id),
    FOREIGN KEY(fk_related_artist) REFERENCES artist(artist_id)
);

CREATE TABLE album(
    album_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    publication_year YEAR(4) NOT NULL,
    cover BLOB,
    fk_artist_id INT NOT NULL,
    PRIMARY KEY(album_id),
    FOREIGN KEY(fk_artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE song(
    song_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    length FLOAT NOT NULL,
    num_reproductions INT,
    fk_album_id INT NOT NULL,
    PRIMARY KEY(song_id),
    FOREIGN KEY(fk_album_id) REFERENCES album(album_id)
);

CREATE TABLE add_song(
    playlist_playlist_id INT NOT NULL,
    song_song_id INT NOT NULL,
    date_added_song DATE NOT NULL,
    fk_addedby_user_id INT NOT NULL,
    PRIMARY KEY(playlist_playlist_id, song_song_id),
    FOREIGN KEY(playlist_playlist_id) REFERENCES playlist(playlist_id),
    FOREIGN KEY(song_song_id) REFERENCES song(song_id)
);
-- ALTER TABLE add_song ADD PRIMARY KEY(playlist_playlist_id, song_song_id,);

CREATE TABLE favourite_songs(
    user_user_id INT NOT NULL,
    song_song_id INT NOT NULL,
    PRIMARY KEY(user_user_id, song_song_id),
    FOREIGN KEY(user_user_id) REFERENCES user(user_id),
    FOREIGN KEY(song_song_id) REFERENCES song(song_id)
);

CREATE TABLE favourite_album(
    user_user_id INT NOT NULL,
    album_album_id INT NOT NULL,
    PRIMARY KEY(user_user_id, album_album_id),
    FOREIGN KEY(user_user_id) REFERENCES user(user_id),
    FOREIGN KEY(album_album_id) REFERENCES album(album_id)
);

CREATE TABLE favourite_artist(
    user_user_id INT NOT NULL,
    artist_artist_id INT NOT NULL,
    PRIMARY KEY(user_user_id, artist_artist_id),
    FOREIGN KEY(user_user_id) REFERENCES user(user_id),
    FOREIGN KEY(artist_artist_id) REFERENCES artist(artist_id)
);