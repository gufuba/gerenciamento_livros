package com.fumagalli.gerenciamento_livros.repositories;

import com.fumagalli.gerenciamento_livros.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
