package com.dosol.community.repository;

import com.dosol.community.domain.StudyBoard;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class StudyBoardRepositoryTests {

    @Autowired
    private StudyBoardRepository studyBoardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            StudyBoard studyBoard = StudyBoard.builder()
                    .title("Title" + i)
                    .content("Content" + i)
                    .build();

            StudyBoard result = studyBoardRepository.save(studyBoard);
            log.info("StudyBoardId" + result.getStudyBoardId());
        });


    }

    @Test
    public void testSelect() {
        Long studyBoardId = 100L;

        Optional<StudyBoard> result = studyBoardRepository.findById(studyBoardId);

        StudyBoard studyBoard = result.orElseThrow();

        log.info(studyBoard);
    }

    @Test
    public void testUpdate () {
        Long studyBoardId = 100L;

        Optional<StudyBoard> result = studyBoardRepository.findById(studyBoardId);

        StudyBoard studyBoard = result.orElseThrow();

        studyBoard.change("update..title 100", "update..content 100");

        studyBoardRepository.save(studyBoard);
    }

    @Test
    public void testDelete () {

        Long studyBoardId = 1L;

        studyBoardRepository.deleteById(studyBoardId);
    }

    @Test
    public void testFindAll() {
        List<StudyBoard> result = studyBoardRepository.findAll();
        log.info(result);
    }
//
//    @Test
//    public void testPaging(){
//        // 1 page order by bno desc
//        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
//
//        Page<Board> result = boardRepository.findAll(pageable);
//
//        log.info("total count : " + result.getTotalElements());
//        log.info("total pages : " + result.getTotalPages());
//        log.info("page number : " + result.getNumber());
//        log.info("page size : " + result.getSize());
//
//        List<Board> todoList = result.getContent();
//
//        todoList.forEach(board -> log.info(board));
//    }
//
//    @Test
//    public void testSearch1() {
//
//        // 2 page order by bno desc
//        Pageable pageable = PageRequest.of(1,10,Sort.by("bno").descending());
//
//        boardRepository.search1(pageable);
//    }
//
//    @Test
//    public void testSearchAll() {
//        String [] types = {"t", "c", "w"};
//
//        String keyword = "1";
//
//        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
//
//        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
//    }
//
//    @Test
//    public void testSearchAll2() {
//
//        String[] types = {"t","c","w"};
//
//        String keyword = "1";
//
//        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
//
//        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
//
//        log.info(result.getTotalPages());
//
//        log.info(result.getSize());
//
//        log.info(result.getNumber());
//
//        log.info(result.hasPrevious() + ": " + result.hasNext());
//
//        result.getContent().forEach(board -> log.info(board));
//    }
}