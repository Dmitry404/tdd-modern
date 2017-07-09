package com.xpinjection.dao;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.xpinjection.domain.Book;
import com.xpinjection.domain.Reader;

import org.junit.Test;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class ReaderDaoTest extends AbstractDaoTest<ReaderDao> {
  @Test
  @ExpectedDataSet("/expected-reader.xml")
  @Commit
  public void readerMayBeSavedWithFavoriteAuthorPreference() throws Exception {
    Reader reader = new Reader("Dmitriy", 34);
    reader.setFavoriteAuthor("Uncle Bob");

    Reader saved = dao.save(reader);

    assertThat(saved.getId(), is(notNullValue()));
  }

  @Test
  @DataSet(value = "stored-books-for-favorite.xml", cleanAfter = true)
  public void findBooksByFavoriteAuthor() throws Exception {
    List<Book> books = dao.findByReaderId(1L);

    Book BOOK = new Book("Clean Code", "Robert C. Martin");
    BOOK.setId(1L);

    assertThat(books, containsInAnyOrder(BOOK));
  }

  @Test
  @DataSet(value = "stored-books-for-favorite.xml", cleanAfter = true)
  public void emptyListOnMissingFavoriteAuthor() throws Exception {
    List<Book> books = dao.findByReaderId(2L);

    assertThat(books, empty());
  }

  @Test
  @DataSet(value = "stored-books-for-favorite.xml", cleanAfter = true)
  public void emptyListOnNotFoundBooks() throws Exception {
    List<Book> books = dao.findByReaderId(3L);

    assertThat(books, empty());
  }
  //todo found long list - paging
}
