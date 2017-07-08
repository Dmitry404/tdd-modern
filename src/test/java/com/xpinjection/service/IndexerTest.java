package com.xpinjection.service;

import com.xpinjection.domain.Book;

import org.junit.Test;

import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IndexerTest {
  @Test
  public void booksCanBeSearchedByKeyword() throws Exception {
    Indexer indexer = new InMemoryIndexer();

    Book BOOK = new Book("Effective Java", "Joshua Bloch");
    Book DUMMY_BOOK = new Book("Egor's Object Language", "Egor Bugaenko");

    indexer.index(BOOK);
    indexer.index(DUMMY_BOOK);

    List<Book> books = indexer.findByKeyword("Java");
    assertThat(books, is(asList(BOOK)));
  }

}