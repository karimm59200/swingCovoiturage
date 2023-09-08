package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment implements Serializable {
    @Id
    private Long id;
    private int idTrip;
    private String title;
    private String comment;

}
