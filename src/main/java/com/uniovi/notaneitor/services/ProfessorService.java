package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    private List<Professor> professors = new ArrayList<>();

    @PostConstruct
    private void init() {
        professors.add(new Professor(1L, "Enol", "García", "11111111A", "Adjunto"));
        professors.add(new Professor(1L, "Lourdes", "Tajes", "22222222B", "Titular"));
    }

    public List<Professor> getProfessors() {
        List<Professor> professorsList = new ArrayList<Professor>(professors);
        return professorsList;
    }
    public Professor getProfessor(Long id) {
        return professors.stream().filter(professor -> professor.getId() == id).findFirst().get();
    }
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }
    public void deleteProfessor(Long id) {
        professors.remove(getProfessor(id));
    }
}
