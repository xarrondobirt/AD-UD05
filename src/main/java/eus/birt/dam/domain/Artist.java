package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "artist")
public class Artist {

	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2", schema = "xarrondo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "genre")
	private String genre;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "birth")
	private Integer birth;

	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Album> albums = new ArrayList<>();

}
