CREATE DATABASE rein;
USE rein;

CREATE TABLE user(
                     no INT PRIMARY KEY AUTO_INCREMENT,            -- 고유번호
                     id VARCHAR(20) UNIQUE KEY NOT NULL,             -- 로그인 아이디
                     pw VARCHAR(300) NOT NULL,                       -- 비밀번호
                     name VARCHAR(100) NOT NULL,                     -- 이름
                     tel VARCHAR(20) NOT NULL,                       -- 전화번호
                     email VARCHAR(100),                             -- 이메일
                     addr1 VARCHAR(100),                             -- 주소
                     addr2 VARCHAR(200),                             -- 상세 주소
                     addr3 VARCHAR(100),                             -- 주요 직거래 주소
                     postcode VARCHAR(10),                           -- 우편 번호
                     status ENUM('ACTIVE','DORMANT','REMOVE'),        -- REMOVE(삭제), DORMANT(휴면), ACTIVE(활동)
                     ROLE ENUM('USER','ADMIN','EMP'),
                     createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 회원 등록일
                     loginAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP     -- 마지막 로그인
);

CREATE TABLE fileobj (
                         no int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '영상번호',
                         cno INT COMMENT '강좌 번호',
                         lno INT COMMENT '강의 번호',
                         savefolder VARCHAR(400) COMMENT '저장경로',
                         originfile VARCHAR(400) COMMENT '실제 파일 이름',
                         savefile VARCHAR(800) COMMENT '난수화된 저장 파일이름',
                         filesize INT COMMENT '파일 사이즈',
                         uploaddate VARCHAR(100),
                         FOREIGN KEY(cno) REFERENCES course(no),
                         FOREIGN KEY(lno) REFERENCES lecture(no)
);

-- board
CREATE TABLE board(
                      no INT PRIMARY KEY AUTO_INCREMENT,   -- (게시글 번호) 자동 발생
                      type ENUM('notice','qna','fileboard') NOT NULL,   -- 게시글 타입: notice, faq, forum, fileboard
                      title VARCHAR(200) NOT NULL,   -- (게시글 제목)
                      content VARCHAR(1000),   -- (게시글 내용)
                      author VARCHAR(16) NOT NULL,   -- (작성자)
                      files VARCHAR(255),
                      regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- (등록일)
                      visited INT DEFAULT 0   -- (조회수)
);