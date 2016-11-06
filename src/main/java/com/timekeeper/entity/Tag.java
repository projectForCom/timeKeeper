package com.timekeeper.entity;

// FIXME add annotations
public class Tag {

  private Long id;

  private Long userId;

  private Long colorId;

  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getColorId() {
    return colorId;
  }

  public void setColorId(Long colorId) {
    this.colorId = colorId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
