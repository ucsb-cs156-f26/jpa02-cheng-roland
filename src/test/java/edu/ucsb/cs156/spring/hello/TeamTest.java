package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_returns_true() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_different_class_returns_false() {
        assertEquals(false, team.equals("test-team"));
    }

    @Test
    public void equals_same_name_and_members_returns_true() {
        team.addMember("Roland");
        Team other = new Team("test-team");
        other.addMember("Roland");
        assertEquals(true, team.equals(other));
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
        team.addMember("Roland");
        Team other = new Team("test-team");
        other.addMember("Chi");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_different_name_returns_false() {
        Team other = new Team("other-team");
        assertEquals(false, team.equals(other));
    }
    @Test
    public void hashCode_equal_teams_have_equal_hashCodes() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        assertEquals(-1226298695, team.hashCode());
    }
}
