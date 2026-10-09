package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Calvin", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Cow-Van", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team expectedTeam = new Team("f26-05");
        ArrayList<String> expectedMembers = new ArrayList<String>(
                Arrays.asList("Brandon Y", "Calvin", "Jarek", "Jovia", "Noah N", "Tara"));
        expectedTeam.setMembers(expectedMembers);

        Team actualTeam = Developer.getTeam();

        assertEquals("f26-05", actualTeam.getName());
        assertEquals(expectedMembers, actualTeam.getMembers());
        assertEquals(expectedTeam, actualTeam);
    }

}
