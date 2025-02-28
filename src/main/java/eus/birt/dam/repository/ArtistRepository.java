package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eus.birt.dam.domain.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

	// Consulta personalizada para contar los álbumes por artista y orden
	// descendente
	@Query("SELECT a.artist FROM Album a GROUP BY a.artist ORDER BY COUNT(a) DESC")
	List<Artist> findArtistsWithMostAlbums();
}
