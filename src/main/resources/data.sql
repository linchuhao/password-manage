DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
INSERT INTO user(username, password) VALUES
    ('user1','$2a$10$lvGnRGCz/aq13q/NFv42veSySKXbkSG/.F5Szaf7p7SNdWyY621U2'),
    ('user2','$2a$10$FpnDq5Pgm3hNXp2eSIXVYeYxyN14ZRiVEG1xjIe91f9FRJBM4TczW'),
    ('user3','$2a$10$P.D6W.CmlndaLxIV6NiKwO2vOugOoyMuJ683Ap9sBLz.X4uEg5lHO'),
    ('user4','$2a$10$8CLe0xUfb3LMGXtyDXbCeensu58NL6fqVeamm2jO6eG0HkEzGNYtC');