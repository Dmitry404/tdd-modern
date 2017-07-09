package com.xpinjection.dao;

import com.xpinjection.domain.Book;
import com.xpinjection.domain.Reader;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderDao extends JpaRepository<Reader, Long> {
  @Query("SELECT b FROM Book b, Reader r where b.author = r.favoriteAuthor AND r.id = ?1")
  List<Book> findByReaderId(long id);
}
