package org.example.t250331.mapper;

import org.example.t250331.model.domain.Anime;

import java.util.List;

public interface AnimeMapper {
    int insertAnime(Anime anime);
    List<Anime> getAllAnimes();
    int insertAnimeVote(String uuid);
}