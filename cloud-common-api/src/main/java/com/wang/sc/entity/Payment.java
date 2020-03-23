package com.wang.sc.entity;

import java.io.Serializable;

/**
 * @author dwang
 * @create 2020-03-05 14:20
 */
public class Payment implements Serializable {

    private Long id;
    private String serial;

    public Long getId() {
        return this.id;
    }

    public Payment setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getSerial() {
        return this.serial;
    }

    public Payment setSerial(final String serial) {
        this.serial = serial;
        return this;
    }
}
