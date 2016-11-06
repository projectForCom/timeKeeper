package com.timekeeper.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

  @Override
  public void save(Tag tag) {
    databaseMock.save(tag);
  }

  @Override
  public void update(Tag tag) {
    databaseMock.update(tag);

  }

  // FIXME add class and replace this mock
  private static class databaseMock {
    private static List<Tag> tags = new ArrayList<>();

    private static List<Tag> findAllTags() {
      return tags;
    }

    private static void save(Tag tag) {
      Optional<Long> maxId = tags.stream().map(e -> e.getId()).max(Comparator.naturalOrder());
      tag.setId(maxId.orElse(0L) + 1);
      tags.add(tag);
    }

    private static void update(Tag tag) {
      Tag targetTag = tags.stream().filter(e -> e.getId().equals(tag.getId())).findAny().get();
      tags.remove(targetTag);
      tags.add(tag);
    }
  }

}
