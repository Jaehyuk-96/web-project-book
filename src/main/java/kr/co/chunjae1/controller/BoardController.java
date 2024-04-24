package kr.co.chunjae1.controller;


import kr.co.chunjae1.domain.BoardDTO;
import kr.co.chunjae1.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("list", boardService.getList());
    }

    @GetMapping("/register")
    public String register() {
        return "board/register";
    }

    @PostMapping("/register")
    public String register(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        log.info("register:" + boardDTO);

        boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("result", boardDTO.getBno());

        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
            public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("/get or modify");
        BoardDTO boardDTO = boardService.get(bno);
        model.addAttribute("boardDTO", boardDTO);
    }

    @PostMapping("/modify")
    public String modfiy(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        log.info("modify:"+ boardDTO);

        if(boardService.modify(boardDTO)) {
            redirectAttributes.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes redirectAttributes) {
        log.info("remove..." + bno);
        if(boardService.remove(bno)){
            redirectAttributes.addFlashAttribute("result", "success");

        }
        return "redirect:/board/list";
    }
}
