package com.makefire.anonymous.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BasicEntity {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Column(name = "created_date",updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modifiedDate",insertable = false)
    private LocalDateTime modifiedDate;


}
