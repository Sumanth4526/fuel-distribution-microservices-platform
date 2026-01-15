package com.hpcl.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dealers")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dealerCode;      // HPCL-style unique code
    private String name;
    private String location;
    private String contactNumber;
    private boolean active;
}
