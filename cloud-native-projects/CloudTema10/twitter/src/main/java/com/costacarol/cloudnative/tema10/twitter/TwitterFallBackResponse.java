package com.costacarol.cloudnative.tema10.twitter;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class TwitterFallBackResponse {

    private final String errorResponseMsg = "An unexpected error occurred. Please, try again in a few minutes.";

}

