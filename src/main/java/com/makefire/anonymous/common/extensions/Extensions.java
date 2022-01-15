package com.makefire.anonymous.common.extensions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *packageName : com.makefire.anonymous
 * fileName : Extensions
 * author : 최푸름
 * date : 22-01-14
 * description : 확장클래스
 * =================================
 * DATE     AUTHOR   NOTE
 * 22-01-14 최푸름
 * ---------------------------------
 */
public final class Extensions {
    public static final Long toSeoulEpochSecond(LocalDateTime $this$toSeoulEpochSecond) {
        return $this$toSeoulEpochSecond != null ? $this$toSeoulEpochSecond.toEpochSecond(ZoneOffset.of("+09:00")) : null;
    }

    public static final Long toSeoulEpochSecond(Date $this$toSeoulEpochSecond) {
        Long var2;
        if ($this$toSeoulEpochSecond != null) {
            Instant var10000 = $this$toSeoulEpochSecond.toInstant();
            if (var10000 != null) {
                ZonedDateTime var1 = var10000.atZone(ZoneId.of("Asia/Seoul"));
                if (var1 != null) {
                    var2 = var1.toEpochSecond();
                    return var2;
                }
            }
        }
        var2 = null;
        return var2;
    }


    public static final String toDateString(Date $this$toDateString) {
        return LocalDateTime.ofInstant($this$toDateString != null ? $this$toDateString.toInstant() : null, ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public static final List paging(List $this$paging, int page, int pageSize) {
        int startIndex = pageSize * page;
        int endIndex = startIndex + pageSize;
        int size = $this$paging.size();
        return startIndex >= size ? null : (startIndex < size && endIndex >= size ? (List)(new ArrayList((Collection)$this$paging.subList(startIndex, size))) : (List)(new ArrayList((Collection)$this$paging.subList(startIndex, endIndex))));
    }
}
