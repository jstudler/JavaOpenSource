package ch.bfh.thegits.heros.camp.service.impl;

import ch.bfh.thegits.heros.camp.model.Hero;
import ch.bfh.thegits.heros.camp.model.Party;
import ch.bfh.thegits.heros.camp.repository.HeroRepository;
import ch.bfh.thegits.heros.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DefaultPartyService implements PartyService {

    @Autowired
    private HeroRepository heroRepository;

    public Party createParty(String name) {

        System.out.println("Creating party with name "+name+"...");
        Party party = new Party();
        party.setName(name);

        List<Hero> allHeroes = (List<Hero>) heroRepository.findAll();
        Collections.shuffle(allHeroes);
        List<Hero> randomHeroes = new ArrayList<>(allHeroes.subList(0,4));

        System.out.println("Adding heroes to party "+name);
        party.setMembers(randomHeroes);
        System.out.println("Party "+name+" has been created.");
        return party;
    }
}
