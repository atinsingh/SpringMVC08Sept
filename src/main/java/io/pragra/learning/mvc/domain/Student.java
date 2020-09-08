package io.pragra.learning.mvc.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonProperty("post_code")
    private String postCode;

    private String city;

    @OneToMany(targetEntity = Course.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<Course> enrolledCourse;

    private Date createDate;
    private Date updateDate;
}
