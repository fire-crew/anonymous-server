package com.makefire.anonymous.service.board.impl;

import com.makefire.anonymous.domain.user.repository.BoardRepository;
import com.makefire.anonymous.service.board.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName : com.makefire.anonymous
 * fileName : BookServiceImpl
 * author : 강정호
 * date : 22-02-22
 * description : 게시판 비즈니스로직 구현체
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-15 최푸름
 * ---------------------------------
 */
@Service
@AllArgsConstructor
public class BookServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
}

