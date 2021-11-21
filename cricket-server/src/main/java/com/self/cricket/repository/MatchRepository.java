package com.self.cricket.repository;

import java.time.LocalDate;
import java.util.List;

import com.self.cricket.entity.Match;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    @Query("select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :startDate and :endDate order by date desc")
    List<Match> getMatchesByTeamBetweenDates(@Param("teamName") String teamName,
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // List<Match>
    // getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(String
    // teamName1, LocalDate startDate1,
    // LocalDate endDate1, String teamName2, LocalDate startDate2, LocalDate
    // endDate2);

}
