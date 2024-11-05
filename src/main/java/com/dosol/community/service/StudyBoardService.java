package com.dosol.community.service;


import com.dosol.community.dto.StudyBoardDTO;

import java.util.List;

public interface StudyBoardService {

    Long register(StudyBoardDTO studyBoardDTO);

    StudyBoardDTO readOne(Long studyBoardId);

    void modify(StudyBoardDTO studyBoardDTO);

    void remove(Long studyBoardId);

    List<StudyBoardDTO> readAll();

//    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
//
//    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}