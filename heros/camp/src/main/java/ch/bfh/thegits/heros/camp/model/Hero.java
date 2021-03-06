package ch.bfh.thegits.heros.camp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Hero
{
    @Id
    @GeneratedValue( generator = "system-uuid" )
    @GenericGenerator( name = "system-uuid", strategy = "uuid" )
    private String id;

    private String name;
    private int atk;
    private int def;
    private int hp;

    public void print()
    {
        System.out.println( String.format( "Hero %s: Attack: %d, Defence: %d, Health: %d", name, atk, def, hp ) );
    }
}
