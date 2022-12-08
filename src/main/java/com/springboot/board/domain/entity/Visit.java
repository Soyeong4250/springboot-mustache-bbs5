package com.springboot.board.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@ToString(callSuper = true)
public class Visit extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String disease;
    private Integer amount;

    @Builder
    public Visit(Hospital hospital, User user, String disease, Integer amount) {
        this.hospital = hospital;
        this.user = user;
        this.disease = disease;
        this.amount = amount;
    }
}
