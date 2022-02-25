package com.makefire.anonymous.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName : com.makefire.anonymous.domain.common
 * fileName : BaseEntity
 * author : kjho94
 * date : 2022-02-25
 * description :
 * =================================
 * DATE        AUTHOR    NOTE
 * 2022-02-25  kjho94    최초 생성
 * ---------------------------------
 */
@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity{

    @Id
    @GeneratedValue
    private long id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
