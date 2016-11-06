package com.timekeeper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.timekeeper.entity.Tag;
import com.timekeeper.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {
  private static final Logger LOGGER = LoggerFactory.getLogger(TagController.class);

  @Autowired
  private TagService tagService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    LOGGER.info("here: TagController.index");
    model.addAttribute("tags", tagService.findAllTags());
    return "tag/index";
  }

  @RequestMapping(value = "/save/", method = RequestMethod.POST)
  public String save(@RequestParam String name) {
    LOGGER.info("here: TagController.save");
    tagService.save(toTag(name, 0L));
    return "redirect:/tag/";
  }

  @RequestMapping(value = "/update/", method = RequestMethod.POST)
  public String update(@RequestParam String name, @RequestParam Long id) {
    LOGGER.info("here: TagController.update");
    tagService.update(toTag(name, id));
    return "redirect:/tag/";
  }

  @RequestMapping(value = "/delete/", method = RequestMethod.POST)
  public String delete(@RequestParam Long id) {
    LOGGER.info("here: TagController.delete");
    tagService.delete(id);
    return "redirect:/tag/";
  }

  private Tag toTag(String name, Long id) {
    Tag tag = new Tag();
    tag.setId(id);
    tag.setName(name);
    tag.setUserId(0L);
    tag.setColorId(0L);
    return tag;
  }

}
