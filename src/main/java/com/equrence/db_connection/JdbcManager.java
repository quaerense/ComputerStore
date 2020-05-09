package com.equrence.db_connection;

import java.sql.Connection;

public interface JdbcManager {
    Connection getConnection();
}
