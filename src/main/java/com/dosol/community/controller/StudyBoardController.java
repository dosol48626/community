package com.dosol.community.controller;

import com.dosol.community.dto.StudyBoardDTO;
import com.dosol.community.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/studyboard")
@Log4j2
@RequiredArgsConstructor
public class StudyBoardController {

    private final StudyBoardService studyBoardService;

    @GetMapping("/list")
    public void list(Model model) {
        List<StudyBoardDTO> studyBoardDTOS = studyBoardService.readAll();
        model.addAttribute("studyBoardDTOS", studyBoardDTOS);
    }

    @GetMapping("/register")
    public void registerGET() {
    }

    @PostMapping("/register")
    public String registerPOST(StudyBoardDTO studyBoardDTO) {
        Long studyBoardId = studyBoardService.register(studyBoardDTO);
        return "redirect:/studyboard/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long studyBoardId, Model model) {
        StudyBoardDTO studyBoardDTO = studyBoardService.readOne(studyBoardId);
        model.addAttribute("studyBoardDTO", studyBoardDTO);
    }

    @PostMapping("/modify")
    public String modifyPOST(StudyBoardDTO studyBoardDTO) {

        studyBoardService.modify(studyBoardDTO);
        log.info("@@@@@@@@@@@@@@@@@@"+studyBoardDTO);
        return "redirect:/studyboard/list";
    }

    @GetMapping("/remove")
    public String removePOST(Long studyBoardId) {
        studyBoardService.remove(studyBoardId);
        return "redirect:/studyboard/list";
    } //왜 창기는 post로 받은거지?? 버튼이니까 post로 보낼 수가 없는거 아닌가? 근데 나중에 시큐리티할라면 post 써야한다 들은거같은데
}