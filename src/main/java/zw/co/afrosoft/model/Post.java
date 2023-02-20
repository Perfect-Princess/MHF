package zw.co.afrosoft.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Data
@Table(name = "post")
@Entity

public class Post {

    private  static final int MIN_TITLE_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime datePosted;
//    @Length(min = MIN_TITLE_LENGTH,message = "Title must be at least "
//            + MIN_TITLE_LENGTH + "characters long")
    @Column(name = "title",nullable = false)
    @NotEmpty(message = "Please enter title")
    private String title;

    @NotEmpty(message = "Write something please")
    @Column(name = "body",columnDefinition = "TEXT",nullable = false)
    private String body;

//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "creation_date",nullable = false,updatable = false)
//    private LocalDate creationDate;

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Comment> comments;



}
