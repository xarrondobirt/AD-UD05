package eus.birt.dam.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album {
	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe", schema = "xarrondo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "genre")
	private String genre;

	@Column(name = "release")
	private Integer release;

	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;
}
