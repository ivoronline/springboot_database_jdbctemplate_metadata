package com.ivoronline.springboot_database_jdbctemplate_metadata.controller;

import com.ivoronline.springboot_database_jdbctemplate_metadata.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // SELECT RECORD
  //=========================================================================================================
  // Request             => http://localhost:8080/returnColumns
  // Returns JSON Object => { "id":1, "name":"John", "age":10 }
  @ResponseBody
  @GetMapping("/returnColumns")
  public String returnColumns() throws SQLException {
    return myService.returnColumns();
  }

}
