package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DeskRepository extends JpaRepository<Desk, String> {

//    List<Desk> findByDeskAvailableAndRoom_TechnoparkUser(
//            DeskAvailableEnum deskAvailableEnum,
//            TechnoparkUser technoparkUser
//    );

    @Query("""
                SELECT d FROM Desk d 
                WHERE d.room.technoparkUser.id = :technoparkId
                  AND NOT EXISTS (
                    SELECT a FROM Appointment a 
                    WHERE a.desk = d 
                      AND a.appointmentStatus = com.boss.bossBackend.entities.enums.ApprovalStatusEnum.APPROVED
                      AND a.appointmentDate < :endDate 
                      AND a.appointmentDateEnd > :startDate
                )
            """)
    Optional<List<Desk>> findAvailableDeskBetweenDatesAndTechnopark(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("technoparkId") String technoparkId);

}
