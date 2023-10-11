package org.mapping.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Instructor {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

}
