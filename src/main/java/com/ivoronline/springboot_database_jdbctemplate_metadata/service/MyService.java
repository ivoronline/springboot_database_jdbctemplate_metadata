package com.ivoronline.springboot_database_jdbctemplate_metadata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // RETURN COLUMNS
  //=========================================================================================================
  public String returnColumns() throws SQLException {

    //GET METADATA
    DataSource        dataSource = jdbcTemplate.getDataSource();
    Connection        connection = DataSourceUtils.getConnection(dataSource);
    Statement         statement  = connection.createStatement();
    ResultSet         resultSet  = statement.executeQuery("SELECT * FROM PERSON WHERE ID = 1");
    ResultSetMetaData metaData   = resultSet.getMetaData();

    //GET COLUMNS
    String columns = "";
    for (int i = 1; i <= metaData.getColumnCount(); i++) {
      String columnName = metaData.getColumnName(i);
      columns = columns + columnName + ", ";
    }

    //RETURN COLUMNS
    return columns;

  }

}


