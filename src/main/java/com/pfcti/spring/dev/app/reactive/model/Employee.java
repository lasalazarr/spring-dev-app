package com.pfcti.spring.dev.app.reactive.model;

/**
 * advance
 * 27/4/23
 */

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Employee {
    @Id
    int id;
    String name;
    long salary;
}

