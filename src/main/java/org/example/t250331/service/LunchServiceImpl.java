package org.example.t250331.service;

import org.example.t250331.domain.Lunch;
import org.example.t250331.mapper.LunchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LunchServiceImpl implements LunchService {

    private final LunchMapper lunchMapper;

    public LunchServiceImpl(LunchMapper lunchMapper) {
        this.lunchMapper = lunchMapper;
    }

    @Override
    public Lunch getRandomLunch() {
        List<Lunch> lunches = lunchMapper.selectAll();
        Random rand = new Random();
        return lunches.get(rand.nextInt(lunches.size()));
    }
}