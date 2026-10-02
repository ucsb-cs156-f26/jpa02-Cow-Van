package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void default_constructor_has_empty_name_and_no_members() {
        Team emptyTeam = new Team();
        assertEquals("", emptyTeam.getName());
        assertEquals(new ArrayList<String>(), emptyTeam.getMembers());
    }

    @Test
    public void new_team_starts_with_no_members() {
        assertEquals(new ArrayList<String>(), team.getMembers());
    }

    @Test
    public void addMember_appends_members_in_order() {
        team.addMember("Alice");
        team.addMember("Bob");
        assertEquals(new ArrayList<String>(Arrays.asList("Alice", "Bob")), team.getMembers());
    }

    @Test
    public void setName_changes_the_name() {
        team.setName("new-name");
        assertEquals("new-name", team.getName());
    }

    @Test
    public void setMembers_replaces_the_members() {
        ArrayList<String> members = new ArrayList<String>(Arrays.asList("Carol"));
        team.setMembers(members);
        assertEquals(members, team.getMembers());
    }

    @Test
    public void toString_returns_expected_representation() {
        team.addMember("Alice");
        team.addMember("Bob");
        assertEquals("Team(name=test-team, members=[Alice, Bob])", team.toString());
    }

    @Test
    public void toString_of_empty_team_returns_expected_representation() {
        assertEquals("Team(name=, members=[])", new Team().toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_null() {
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_returns_false_for_object_of_different_class() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_returns_true_for_team_with_same_name_and_members() {
        team.addMember("Alice");
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_team_with_different_name() {
        team.addMember("Alice");
        Team other = new Team("other-team");
        other.addMember("Alice");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_team_with_different_members() {
        team.addMember("Alice");
        Team other = new Team("test-team");
        other.addMember("Bob");
        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_matches_name_hash_or_members_hash() {
        team.addMember("Alice");
        ArrayList<String> expectedMembers = new ArrayList<String>(Arrays.asList("Alice"));
        assertEquals("test-team".hashCode() | expectedMembers.hashCode(), team.hashCode());
    }

    @Test
    public void hashCode_is_equal_for_equal_teams() {
        team.addMember("Alice");
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertTrue(team.equals(other));
        assertEquals(team.hashCode(), other.hashCode());
    }

}
