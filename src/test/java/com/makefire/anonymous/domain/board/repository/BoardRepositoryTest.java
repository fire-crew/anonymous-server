package com.makefire.anonymous.domain.board.repository;

import com.makefire.anonymous.domain.board.entity.Board;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // FIXME -> MemoryDB 사용할 수 있도록 변경 필요
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board board;

    @BeforeEach
    void setUp() {
        board = Board.builder()
                .title("Test Title")
                .contents("Test Contents")
                .author("Test Author")
                .build();
    }

    @Test
    @DisplayName("BoardRepository 데이터 적재 테스트")
    void saveBoardTest() {
        // when
        Board savedBoard = boardRepository.save(board);

        // then
        Assertions.assertAll(
                () -> assertEquals(board.getTitle(), savedBoard.getTitle()),
                () -> assertEquals(board.getContents(), savedBoard.getContents()),
                () -> assertEquals(board.getAuthor(), savedBoard.getAuthor())
        );
    }
}