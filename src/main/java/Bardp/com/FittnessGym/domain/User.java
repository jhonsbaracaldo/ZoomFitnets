package Bardp.com.FittnessGym.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table ( schema =  "\"register\"",name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private Integer number;

    private String email;

    private String blood_type;

    private Date date_initial;

    private Date date_End;
 //Estatus
    private Status status;

}
