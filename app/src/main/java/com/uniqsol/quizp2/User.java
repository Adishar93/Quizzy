package com.uniqsol.quizp2;
import android.arch.persistence.room.*;


    @Entity(tableName = "user")
    public class User {
        @PrimaryKey(autoGenerate = true)
        private int uid;

        @ColumnInfo(name = "username")
        private String username;

        @ColumnInfo(name = "password")
        private String password;
        @ColumnInfo(name = "name")
        private String name;
        @ColumnInfo(name = "email")
        private String email;

        public int getUid()
        {
            return uid;
        }
        public String getUsername()
        {
            return username;
        }
        public String getPassword()
        {
            return password;
        }
        public String getName()
        {
            return name;
        }

        public String getEmail()
        {
            return email;
        }


        public void setUid(int uid)
        {
            this.uid = uid;
        }
        public void setUsername(String username)
        {
            this.username=username;
        }
        public void setPassword(String password)
        {
            this.password=password;
        }
        public void setName(String name)
        {
            this.name=name;
        }
        public void setEmail(String email)
        {
            this.email=email;
        }
    }

