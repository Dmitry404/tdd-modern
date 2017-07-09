package com.xpinjection.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reader {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private int age;
  @Column (name = "fav_author")
  private String favoriteAuthor;

  public Reader() {
  }

  public Reader(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setFavoriteAuthor(String favoriteAuthor) {
    this.favoriteAuthor = favoriteAuthor;
  }

  public Long getId() {
    return id;
  }
}
