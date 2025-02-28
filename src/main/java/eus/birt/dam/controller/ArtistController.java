package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Artist;
import eus.birt.dam.repository.ArtistRepository;

@Controller
@RequestMapping("/artist")
public class ArtistController {

	@Autowired
	ArtistRepository artistRepo;

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		artistRepo.deleteById(id);
		return "redirect:/artist";
	}

	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Artist artist = new Artist();
		model.addAttribute("artist", artist);
		return "artistForm";
	}

	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Artist artist) {
		artistRepo.save(artist);
		return "redirect:/artist";
	}

	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artist", artistRepo.findById(id));
		return "artistForm";
	}
}
