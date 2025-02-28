package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.domain.Artist;
import eus.birt.dam.repository.AlbumRepository;
import eus.birt.dam.repository.ArtistRepository;

@Controller
public class MainController {

	@Autowired
	private AlbumRepository albumRepo;

	@Autowired
	private ArtistRepository artistRepo;

	@GetMapping({ "/", "/welcome" })
	public String welcome() {
		return "index";
	}

	@GetMapping({ "/album" })
	public String getAlbum(Model model) {
		model.addAttribute("album", albumRepo.findAll());
		return "album";
	}

	@GetMapping({ "/artist" })
	public String getArtist(Model model) {
		model.addAttribute("artist", artistRepo.findAll());
		return "artist";
	}

	@GetMapping({ "/top-artist" })
	public String getTopArtists(Model model) {
		List<Artist> artist = artistRepo.findArtistsWithMostAlbums();
		model.addAttribute("artist", artist);
		return "top-artist";
	}
}
