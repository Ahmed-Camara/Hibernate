package org.mapping.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDetail {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) // delete detail but keep instructor in the db
    private Instructor instructor;

    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
    }

}
