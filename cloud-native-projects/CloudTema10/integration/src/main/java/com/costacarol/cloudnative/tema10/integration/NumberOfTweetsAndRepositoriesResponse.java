package com.costacarol.cloudnative.tema10.integration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumberOfTweetsAndRepositoriesResponse {

    private Object twitter;
    private Object github;

}
