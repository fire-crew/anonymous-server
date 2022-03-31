package com.makefire.anonymous.domain.user.repository;

import com.makefire.anonymous.domain.user.entity.QUser;
import com.makefire.anonymous.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAInsertClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    QUser user = QUser.user;

    @Override
    public User getUser(String name) {
        return queryFactory
                .selectFrom(user)
                .where(user.name.eq(name))
                .fetchOne();
    }

    @Override
    public List<User> getUserList() {
        return queryFactory
                .selectFrom(user)
                .fetch();
    }
}


