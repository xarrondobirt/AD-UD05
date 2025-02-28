package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}