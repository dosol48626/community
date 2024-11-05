package com.dosol.community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class StudyBoard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyBoardId;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ColumnDefault("0")
    private int visitcount;

    public void updateVisitCount(){
        this.visitcount++;
    }

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
//    @ManyToOne
//    private User user;
}
