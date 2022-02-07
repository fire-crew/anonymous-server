package com.makefire.anonymous.domain.board.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="sample_board")
public class Board {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String boardName;

    Date postingTime;
}
