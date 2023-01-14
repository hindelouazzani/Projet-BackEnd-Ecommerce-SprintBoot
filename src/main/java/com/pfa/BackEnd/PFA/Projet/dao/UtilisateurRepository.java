package com.pfa.BackEnd.PFA.Projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}
