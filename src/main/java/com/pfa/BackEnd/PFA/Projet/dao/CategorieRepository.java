package com.pfa.BackEnd.PFA.Projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
