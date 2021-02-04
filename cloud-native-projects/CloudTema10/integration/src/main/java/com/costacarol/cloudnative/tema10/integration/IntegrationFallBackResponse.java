package com.costacarol.cloudnative.tema10.integration;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class IntegrationFallBackResponse {

    private final String mgsErrorResponse = "An unexpected error occurred. Please, try again in a few minutes.";

}

