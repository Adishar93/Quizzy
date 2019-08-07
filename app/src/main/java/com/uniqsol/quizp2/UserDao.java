package com.uniqsol.quizp2;
import android.arch.persistence.room.*;
import java.util.*;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Query("SELECT * FROM user WHERE username=:username LIMIT 1")
    User findByUsername(String username);

    @Insert
    void insertAll(User... users);
    @Insert
    void insertUser(User user);

    @Delete
    void delete(User user);
}
