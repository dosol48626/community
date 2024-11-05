package com.dosol.community.service;

import com.dosol.community.domain.StudyBoard;
import com.dosol.community.dto.StudyBoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Log4j2
public class StudyBoardServiceTests {

    @Autowired
    private StudyBoardService studyBoardService;

    @Test
    public void testRegister() {
        log.info(studyBoardService.getClass().getName());

        StudyBoardDTO studyBoardDTO = StudyBoardDTO.builder()
                .title("Sample Title")
                .content("Sample Content")
                .build();

        Long studyBoardId = studyBoardService.register(studyBoardDTO);

        log.info("studyBoardId :" + studyBoardId);
    }

    @Test
    public void testModify() {

        StudyBoardDTO studyBoardDTO = StudyBoardDTO.builder()
                .studyBoardId(2L)
                .title("Updated 2")
                .content("Updated Content 2")
                .build();

        studyBoardService.modify(studyBoardDTO);
    }

    @Test
    public void testDelete() {
        Long studyBoardId = 2L;
        studyBoardService.remove(studyBoardId);
    }

    @Test
    public void testFindById(){
        Long studyBoardId = 3L;
        studyBoardService.readOne(studyBoardId);
    }

    @Test
    public void testFindAll() {
        List<StudyBoardDTO> studyBoardDTOS = studyBoardService.readAll();
        log.info(studyBoardDTOS);
    }
//    @Test
//    public void testList() {
//
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .type("tcw")
//                .keyword("1")
//                .page(1)
//                .size(10)
//                .build();
//
//        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.list(pageRequestDTO);
//
//        log.info(pageResponseDTO);
//    }
//
//    @Test
//    public void testListWithReplyCount() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page(1)
//                .size(10)
//                .type("tcw")
//                .keyword("9")
//                .link(null)
//                .build();
//
//        PageResponseDTO<BoardListReplyCountDTO> result = boardService.listWithReplyCount(pageRequestDTO);
//
//        log.info(result);
//
//    }
}