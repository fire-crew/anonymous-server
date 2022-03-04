package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * packageName : com.makefire.anonymous.domain.board.repository
 * fileName : BoardRepositoryTest
 * author : kjho94
 * date : 2022-03-03
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-03-03  kjho94    최초 생성
 * ---------------------------------
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // FIXME MemoryDB 사용할 수 있도록 변경 필요
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void saveBoardTest() {
        // given
        String title = "Test Title";
        String contents = "Test Contents";
        String author = "Test Author";
        Board board = Board.builder()
                .title(title)
                .contents(contents)
                .author(author)
                .build();

        // when
        Board savedBoard = boardRepository.save(board);

        // then
        Assertions.assertEquals(title, savedBoard.getTitle(), "saveBoardTest ::: Title");
        Assertions.assertEquals(contents, savedBoard.getContents(), "saveBoardTest ::: Contents");
        Assertions.assertEquals(author, savedBoard.getAuthor(), "saveBoardTest ::: Author");
    }
}