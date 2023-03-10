package com.uniovi.notaneitor.repositories;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarksRepository extends CrudRepository<Mark, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);

    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC")
    Page<Mark> findAllByUser(Pageable pageable, User user);
    /*
    Nota: Sí que sería necesario utilizar el atributo @Query si siquieramos hacer una consulta
    más especifica que no sea simplemente un select de un parámetro. Por ejemplo, solo las
    notas con un valor de 5 o más. Es decir. aplicar filtros con WHERE:
    @Query("SELECT r FROM Mark r WHERE r.user = ?1 AND r.score >= 5 ")
    List<Mark> findAllPassedByUser(User user);
    */

    @Query("Select r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1) )")
    Page<Mark> searchByDescriptionAndName(Pageable pageable, String searchText);

    @Query("Select r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1) ) AND r.user = ?2")
    Page<Mark> searchByDescriptionNameAndUser(Pageable pageable, String searchText, User user);

    Page<Mark> findAll(Pageable pageable);


}
