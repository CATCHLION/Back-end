package com.example.mbti.Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mbti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 50)
    private String mbtiw;

    @Column()
    private String info;

    public Mbti(String mbtiw, String info){
        this.mbtiw = mbtiw;
        this.info = info;
    }
}

