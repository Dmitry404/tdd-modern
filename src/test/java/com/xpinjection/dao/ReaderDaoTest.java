package com.xpinjection.dao;

import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.xpinjection.domain.Reader;

import org.junit.Test;
import org.springframework.test.annotation.Commit;

import static org.hamcrest.core.Is.is;
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
}
