package com.xpinjection.service;

import com.xpinjection.domain.Book;

import java.util.List;

public interface Indexer {
  void index(Book book);

  List<Book> findByKeyword(String keyword);
}
