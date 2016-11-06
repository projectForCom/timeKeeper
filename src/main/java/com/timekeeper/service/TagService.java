package com.timekeeper.service;

import java.util.List;

import com.timekeeper.entity.Tag;

public interface TagService {

  public List<Tag> findAllTags();

  public void save(Tag tag);

  public void update(Tag tag);
}
