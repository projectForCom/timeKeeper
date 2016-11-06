package com.timekeeper.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.timekeeper.entity.Tag;
import com.timekeeper.service.TagService;

@Service
public class TagServiceImpl implements TagService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TagServiceImpl.class);

  @Override
  public List<Tag> findAllTags() {
    return databaseMock.findAllTags();
  }


  // FIXME add class and replace this mock
  private static class databaseMock {
    private static List<Tag> tags;

    private databaseMock() {
      tags = new ArrayList<>();
    }

    private static List<Tag> findAllTags() {
      return tags;
    }
  }
}
