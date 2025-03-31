package org.example.t250331.controller;

import org.apache.ibatis.session.SqlSession;
import org.example.t250331.config.MyBatisConfig;
import org.example.t250331.mapper.AnimeMapper;
import org.example.t250331.mapper.TestMapper;
import org.example.t250331.model.domain.Anime;
import org.example.t250331.model.dto.AnimeRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
//            TestMapper testMapper = session.getMapper(TestMapper.class);
//            int result = testMapper.selectOnePlusOne();
            AnimeMapper animeMapper = session.getMapper(AnimeMapper.class);
            List<Anime> result = animeMapper.getAllAnimes();
            model.addAttribute("result", result);
        }
        return "index";
    }

    @PostMapping("/anime")
    public String anime(Model model, @ModelAttribute AnimeRequestDTO dto) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            AnimeMapper animeMapper = session.getMapper(AnimeMapper.class);
            int count = animeMapper.insertAnime(
                    new Anime(
                            UUID.randomUUID().toString(),
                            dto.title(), dto.description(),
                            "", 0
                    ));
            session.commit();
        }
        return "redirect:/";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam("uuid") String uuid) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            AnimeMapper animeMapper = session.getMapper(AnimeMapper.class);
            animeMapper.insertAnimeVote(uuid);
            session.commit();
        }
        return "redirect:/";
    }
}