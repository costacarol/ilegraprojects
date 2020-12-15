package com.costacarol.cloudnative.tema7.integration.model;

import lombok.*;


@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IntegrationErrorResponse {

    @Setter
    private Integer statusErrorCode;
    private final String mgsErrorResponse = "The requested page could not be found. Check the insert data and try again.";

}
