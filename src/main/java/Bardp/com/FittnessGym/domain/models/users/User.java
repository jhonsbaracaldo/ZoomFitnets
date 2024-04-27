package Bardp.com.FittnessGym.domain.models.users;

import Bardp.com.FittnessGym.domain.category.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    private String lastname;

    private Integer number;

    private String email;

    private String blood_type;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_initial;



    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_End;
 //Estatus
    private Status status;

}
