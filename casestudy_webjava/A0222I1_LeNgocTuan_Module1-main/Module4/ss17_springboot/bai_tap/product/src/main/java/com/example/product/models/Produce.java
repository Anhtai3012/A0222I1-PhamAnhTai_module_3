package com.example.product.models;

import com.example.product.dto.ProduceDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "produce")
public class Produce implements Serializable {
    private static final long serialVersionUID = -291232132133233123L;

    public Produce(ProduceDto produceDto) {
        this(null,
                produceDto.getName(),
                produceDto.getDateToUse(),
                produceDto.getNation(),
                produceDto.getAvatar(),
                produceDto.getColor(),
                produceDto.getPromote());
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @Column(name = "date_to_use")
    Date dateToUse;
    String nation;
    String avatar;
    String color;
    Boolean promote;
}
