package com.xpinjection.service;

import com.xpinjection.domain.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Indexer {
  private final Map<String, Book> booksIndex = new ConcurrentHashMap<>();

  public void index(Book book) {
    String[] keywords = book.getName().split(" ");
    Arrays.stream(keywords).forEach(k -> booksIndex.put(k, book));
  }

  public List<Book> findByKeyword(String keyword) {
    return Arrays.asList(booksIndex.get(keyword));
  }
}
