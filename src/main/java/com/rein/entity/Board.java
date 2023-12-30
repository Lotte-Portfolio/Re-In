package com.rein.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    private String boardType;

    private Long fileId;

    @CreationTimestamp  //@CreatedDate = LocalDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp    //@LastModifiedDate = LocalDate
    @Column(name = "moddate")
    private LocalDateTime modDate;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
        this.boardType = boardType;
    }

    @Builder
    public Board(Integer bno, String title, String content, String writer, Long fileId) {
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.fileId = fileId;
    }
}
