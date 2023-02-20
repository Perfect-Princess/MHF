package zw.co.afrosoft.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostRequest {

    @Column(name = "title",nullable = false)
    @NotEmpty(message = "Please enter title")
    private String title;

    @NotEmpty(message = "Write something please")
    @Column(name = "body",columnDefinition = "TEXT",nullable = false)
    private String body;
}
