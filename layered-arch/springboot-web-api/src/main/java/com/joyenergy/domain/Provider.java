package com.joyenergy.domain;

import com.joyenergy.domain.command.ProviderCreateCommand;
import com.joyenergy.domain.command.ProviderUpdateCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "providers")
public class Provider implements Serializable {

    @Id
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-generator")
    private UUID id;

    @Column(nullable = false)
    private String name;

    public static Provider create(ProviderCreateCommand command){
        return Provider.builder().name(command.getTitle()).build();
    }

    public void update(ProviderUpdateCommand command) {
        this.name = command.getTitle();
    }


}
