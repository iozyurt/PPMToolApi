package ismail.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @NotBlank(message = "Project name is required")
    private String projectName;
    @Getter
    @Setter
    @NotBlank(message = "Project identifier is required")
    @Size(min = 4, max = 6, message = "Please use 4 to 6 characters")

    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @Getter
    @Setter
    @NotBlank(message = "Project description is required")
    private String description;
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;
    @Getter
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date created_At;
    @Getter
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
}
