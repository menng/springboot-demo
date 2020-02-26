package org.springboot.demo.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8735676195849103004L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
