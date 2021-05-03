package com.commons.users.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EntityScan({"com.commons.memberships.service.entities" , "com.commons.reservations.service.entities"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class UsersServiceCommonsApplication {

}
