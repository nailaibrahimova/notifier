package az.pashabank.exam.notifier.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "everyday_data")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "city")
    private String city;
}
