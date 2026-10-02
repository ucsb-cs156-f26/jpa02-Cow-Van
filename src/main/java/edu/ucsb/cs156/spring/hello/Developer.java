package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Calvin";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "Cow-Van";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("team-f26-05");
        team.addMember("Brandon Y");
        team.addMember("Calvin");
        team.addMember("Jarek");
        team.addMember("Jovia");
        team.addMember("Noah N");
        team.addMember("Tara");
        return team;
    }
}
