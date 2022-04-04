package com.makefire.anonymous.domain.user.repository;

import com.makefire.anonymous.domain.user.entity.QUser;
import com.makefire.anonymous.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    QUser qUser = QUser.user;

    @Override
    public Long insertUser(User user) {
        queryFactory.insert(qUser)
                .columns(qUser.name)
                .values(user.getName());
        return 1L;
    }

    @Override
    public User getUser(String name) {
        return queryFactory
                .selectFrom(qUser)
                .where(qUser.name.eq(name))
                .fetchOne();
    }

    @Override
    public List<User> getUserList() {
        return queryFactory
                .selectFrom(qUser)
                .fetch();
    }

    @Override
    public Long updateUser(String oldName, String newName) {
        queryFactory.update(qUser)
                .where(qUser.name.eq(oldName))
                .set(qUser.name, newName)
                .execute();
        return 1L;
    }

    @Override
    public Long deleteUser(String name) {
        queryFactory.delete(qUser)
                .where(qUser.name.eq(name))
                .execute();
        return 1L;
    }
}


