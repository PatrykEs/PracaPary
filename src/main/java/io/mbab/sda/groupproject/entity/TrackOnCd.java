package io.mbab.sda.groupproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrackOnCd {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 64, nullable = false)
  private String trackName;

  @Column(columnDefinition = "int default 0")
  private Integer trackTime;

  @ManyToOne
  @JoinColumn(name = "cd_id")
  private Cd cd;
}
