package com.costacarol.cloudnative.tema7.github.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGithub {

    private String name;
    private String id;
    private int public_repos;

}
