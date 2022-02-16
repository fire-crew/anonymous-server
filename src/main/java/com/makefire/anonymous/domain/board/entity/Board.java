package com.makefire.anonymous.domain.board.entity;

import com.makefire.anonymous.common.extensions.Common;
import lombok.Data;

import javax.persistence.Entity;


@Data
@Entity
public class Board extends Common {


    private String boardName;

}
