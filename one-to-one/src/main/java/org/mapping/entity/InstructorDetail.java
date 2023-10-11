package org.mapping.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorDetail {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;
}
