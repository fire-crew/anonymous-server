package com.makefire.anonymous.common.extensions;


import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Common {
    @Id
    @GeneratedValue
    Long id;

}
