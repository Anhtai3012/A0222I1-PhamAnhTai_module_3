package com.call_sp;

import lombok.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class User {
    int id;
    String name;
    String email;
    String country;
}
