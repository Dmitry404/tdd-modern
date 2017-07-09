package com.xpinjection.service;

import com.xpinjection.domain.Book;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryIndexer implements Indexer {
  private final Map<String, Book> booksIndex = new ConcurrentHashMap<>();

  @Override
  public void index(Book book) {
    String[] keywords = book.getName().split(" ");
    Arrays.stream(keywords).forEach(k -> booksIndex.put(k, book));
  }

  @Override
  public List<Book> findByKeyword(String keyword) {
    return Arrays.asList(booksIndex.get(keyword));
  }
}
