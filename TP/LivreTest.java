package org.formation.mabiblio.business.dto;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LivreTest {

	@Test
	public void testGetAuteursFormates() {
		Livre l = new Livre();
		Set<Auteur> auteurs = new HashSet<Auteur>();
		auteurs.add(new Auteur("Cyril", "Dumont"));
		auteurs.add(new Auteur("Isabelle", "Ruffier"));
		l.setAuteurs(auteurs);
//		String expected = "Cyril Dumont, Isabelle Ruffier";
		String expected = "Isabelle Ruffier, Cyril Dumont";
		assertEquals(expected, l.getAuteursFormates());
	}

}
