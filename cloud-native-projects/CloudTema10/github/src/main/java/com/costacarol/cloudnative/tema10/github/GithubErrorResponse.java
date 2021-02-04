package com.costacarol.cloudnative.tema10.github;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GithubErrorResponse{

        @Setter
        private int statusCode;
        private final String errorResponseMsg = "The requested page could not be found. Check the insert data and try again.";

    }
