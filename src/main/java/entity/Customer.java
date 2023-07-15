package entity;

import entity.process.FileResourse;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long publicId;
    private String name;
    private String address;
    private double salary;

    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    @Embedded
    private FileResourse fileResourse;


}
