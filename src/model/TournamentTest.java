package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    Tournament tournament;
    Team team;

    @BeforeEach
    void newTournament(){
        tournament = new Tournament();
    }

    @Test
    void getPlayer() {
        tournament.setPlayer(new Player("John Doe"));
        assertEquals("John Doe", tournament.getPlayer(0));
    }

    @Test
    void removePlayer(){
        tournament.setPlayer(new Player("John Doe"));
        tournament.removePlayer(0);
        assertEquals(0, tournament.getArrayListPlayers().size());
    }

    @Test
    void getTeam(){
        tournament.setTeam(new Team("Team1"));
        Team team1 = tournament.getTeam(0);

        tournament.setTeam(new Team("Team2"));
        Team team2 = tournament.getTeam(1);

        assertEquals(team1, tournament.getTeam(0));
    }

    @Test
    void invalidGetTeam(){
        tournament.setTeam(new Team("Team1"));
        tournament.setTeam(new Team("Team2"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tournament.getTeam(-1);
        });
    }
}