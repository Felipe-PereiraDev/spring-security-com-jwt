package com.projeto.dio.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
@Getter
@Setter
@ToString
public class User {
    @Id
    private String username;
    private String password;
}
