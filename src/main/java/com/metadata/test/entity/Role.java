package com.metadata.test.entity;

import com.metadata.test.util.RoleEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "metadataio")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;

}
