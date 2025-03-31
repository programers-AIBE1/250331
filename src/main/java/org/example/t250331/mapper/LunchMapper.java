package org.example.t250331.mapper;

import org.example.t250331.domain.Lunch;

import java.util.List;

public interface LunchMapper {
    List<Lunch> selectAll();
}