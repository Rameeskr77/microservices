package com.customer;

import lombok.*;

import javax.persistence.*;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @SequenceGenerator(
            name = "Customer_id_sequence",
            sequenceName = "Customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Customer_id_sequence"
    )
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
