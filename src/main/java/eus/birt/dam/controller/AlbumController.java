package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Album;
import eus.birt.dam.repository.AlbumRepository;
import eus.birt.dam.repository.ArtistRepository;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	ArtistRepository artistRepo;

	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		albumRepo.deleteById(id);
		return "redirect:/album";
	}

	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Album album = new Album();
		model.addAttribute("album", album);
		model.addAttribute("artist", artistRepo.findAll());
		return "albumForm";
	}

	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Album album) {
		albumRepo.save(album);
		return "redirect:/album";
	}

	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("album", albumRepo.findById(id));
		model.addAttribute("artist", artistRepo.findAll());
		return "albumForm";
	}
}