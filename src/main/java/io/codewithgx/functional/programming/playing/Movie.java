package io.codewithgx.functional.programming.playing;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 18/09/2022
 */

public class Movie {
    private  String name;
    private int releaseYear;
    private String industry;


    private Movie(String name, int releaseYear, String industry) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.industry = industry;
    }

    public static Movie of(String name, int releaseYear, String industry) {
        return new Movie(name, releaseYear, industry);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(final String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return String.format("""
                %s:\040
                    \040{\040
                        "name" : "%s",
                        "releaseYear" : "%s",
                        "industry" : "%s"
                    \040}
                """,
                this.getClass().getSimpleName() + " [" + getName() + "]",
                this.getName(),
                this.getReleaseYear(),
                this.getIndustry());
    }
}
