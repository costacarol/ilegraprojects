package com.costacarol.cloudnative.tema10.twitter;

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
