package com.dosol.community.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudyBoardDTO {
    private Long studyBoardId;

    private String title;

    private String content;

    private int visitcount;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
