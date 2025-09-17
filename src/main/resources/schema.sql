-- cardflow-ai : 초기 스키마 (dev 프로필)

CREATE TABLE IF NOT EXISTS transactions (
                                            id           BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            user_id      BIGINT       NOT NULL,
                                            amount       DECIMAL(15,2) NOT NULL,
    currency     VARCHAR(3)   NOT NULL,     -- ISO 4217
    country      VARCHAR(2)   NOT NULL,     -- ISO 3166-1 alpha-2
    channel      VARCHAR(20)  NOT NULL,     -- WEB/APP/POS/CALL 등
    status       VARCHAR(20)  NOT NULL,     -- APPROVED/DECLINED/PENDING
    tx_datetime  DATETIME     NOT NULL,
    tx_date      DATE GENERATED ALWAYS AS (DATE(tx_datetime)) VIRTUAL,
    merchant     VARCHAR(100),
    created_at   DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_user_date (user_id, tx_datetime),
    INDEX idx_country_status (country, status),
    INDEX idx_tx_date (tx_date)
    );

-- (선택) 코드 테이블 예시
CREATE TABLE IF NOT EXISTS country_code (
                                            code VARCHAR(2) PRIMARY KEY,  -- KR, US ...
    name_ko VARCHAR(100) NOT NULL,
    name_en VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS channel_code (
                                            code VARCHAR(20) PRIMARY KEY, -- WEB, APP, POS, CALL
    description VARCHAR(100) NOT NULL
    );
