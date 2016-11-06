package com.timekeeper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
