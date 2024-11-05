package com.dosol.community.service;

import com.dosol.community.domain.StudyBoard;
import com.dosol.community.dto.StudyBoardDTO;
import com.dosol.community.repository.StudyBoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class StudyBoardServiceImpl implements StudyBoardService {

    private final ModelMapper modelMapper;

    private final StudyBoardRepository studyBoardRepository;

    @Override
    public Long register(StudyBoardDTO studyBoardDTO) {
        StudyBoard studyBoard = modelMapper.map(studyBoardDTO, StudyBoard.class);

        Long studyBoardId = studyBoardRepository.save(studyBoard).getStudyBoardId();

        return studyBoardId;
    }

    @Override
    public StudyBoardDTO readOne(Long studyBoardId) {

        Optional<StudyBoard> result = studyBoardRepository.findById(studyBoardId);

        StudyBoard studyBoard = result.orElseThrow();

        StudyBoardDTO studyBoardDTO = modelMapper.map(studyBoard, StudyBoardDTO.class);

        log.info(studyBoardDTO);

        return studyBoardDTO;
    }

    @Override
    public void modify(StudyBoardDTO studyBoardDTO) {

        Optional<StudyBoard> result = studyBoardRepository.findById(studyBoardDTO.getStudyBoardId());
        StudyBoard studyBoard = result.orElseThrow();
        studyBoard.change(studyBoardDTO.getTitle(), studyBoardDTO.getContent());

        studyBoardRepository.save(studyBoard);
    }

    @Override
    public void remove(Long studyBoardId) {
        studyBoardRepository.deleteById(studyBoardId);
    }

    @Override
    public List<StudyBoardDTO> readAll() {
        List<StudyBoard> studyBoards = studyBoardRepository.findAll();

        // List<StudyBoard>를 List<StudyBoardDTO>로 변환
        List<StudyBoardDTO> studyBoardDTOs = studyBoards.stream()
                .map(studyBoard -> modelMapper.map(studyBoard, StudyBoardDTO.class))
                .collect(Collectors.toList());

        return studyBoardDTOs; // DTO 리스트 반환
    }

//    @Override
//    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
//
//        String[] types = pageRequestDTO.getTypes();
//        String keyword = pageRequestDTO.getKeyword();
//        Pageable pageable = pageRequestDTO.getPageable("bno");
//
//        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
//
//        List<BoardDTO> dtoList = result.getContent().stream()
//                .map(board -> modelMapper.map(board,BoardDTO.class))
//                .collect(Collectors.toList());
//
//        return PageResponseDTO.<BoardDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(dtoList)
//                .total((int)result.getTotalElements())
//                .build();
//    }
//
//    @Override
//    public PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO) {
//
//        String[] types = pageRequestDTO.getTypes();
//        String keyword = pageRequestDTO.getKeyword();
//        Pageable pageable = pageRequestDTO.getPageable("bno");
//
//        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);
//
//        return PageResponseDTO.<BoardListReplyCountDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(result.getContent())
//                .total((int)result.getTotalElements())
//                .build();
//    }
}