package com.costacarol.cloudnative.tema7.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumberOfTweetsAndRepositoriesResponse {

    private Object twitter;
    private Object github;

}
