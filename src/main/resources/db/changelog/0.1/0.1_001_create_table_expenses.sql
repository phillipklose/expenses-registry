-- changeset liquibase: 0.1_001
CREATE TABLE expenses
(
    id          INT            NOT NULL AUTO_INCREMENT,
    user_id     INT            NOT NULL,
    amount      DECIMAL(19, 4) NOT NULL,
    currency    VARCHAR(20)    NOT NULL,
    occurred_at DATETIME       NOT NULL,
    PRIMARY KEY (id)
)