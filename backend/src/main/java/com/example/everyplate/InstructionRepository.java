package com.example.everyplate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    List<Instruction> findAllByMealIdOrderByStepNumber(Long id);
}
