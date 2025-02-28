/*
package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Cyclist;
import eus.birt.dam.repository.CyclistRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private CyclistRepository cyclistRepository;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		Cyclist cyclist1 = new Cyclist("Geraint", "Thomas",LocalDate.parse("1989-04-04"),"UK");
		cyclistRepository.save(cyclist1);
		System.out.println("Started in Bootstrap");
        System.out.println("Number of cyclists: " + cyclistRepository.count());
			
	}
	
}*/