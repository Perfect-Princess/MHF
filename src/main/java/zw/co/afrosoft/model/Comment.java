package zw.co.afrosoft.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name="comments")
@SequenceGenerator(name = "comment_seq_gen",sequenceName = "comment_seq",initialValue = 10,allocationSize = 1)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_seq_gen")
   private Long id;
    @NotEmpty(message = "Write something please")
    @Column(name = "body",columnDefinition = "TEXT",nullable = false)
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date",nullable = false,updatable = false)
    private Date creationDate;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id",nullable = false)
    private Post post;
}
