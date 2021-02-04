package com.costacarol.cloudnative.tema10.github;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class GithubFallBackResponse {

    private final String msgError = "An unexpected error occurred. Please, check the insert data and try again in a few minutes.";
}
