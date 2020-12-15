package com.costacarol.cloudnative.tema7.twitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTwitter {

    private String name;
    private String id;
    private int numberOfTweets;

}
