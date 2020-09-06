package io.mbab.sda.groupproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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

  @Column(length = 4, nullable = false)
  private LocalDate albumDate;

  @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  List<TrackOnCd> tracksOnCd;
}
