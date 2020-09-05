package io.mbab.sda.groupproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String bandName;

    @Column(length = 64, nullable = false)
    private String albumName;

    private int albumYear;

  //  @OneToMany
    //List<Song> albumTrack;
}
