package Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private String name;
    private String timing;
    private int seatsAvailable;

    public Movie(String name, String timing, int seatsAvailable) {
        this.name = name;
        this.timing = timing;
        this.seatsAvailable = seatsAvailable;
    }

    public String getName() {
        return name;
    }

    public String getTiming() {
        return timing;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}

public class MultiplexManagementSystem {
    private List<Movie> movies;
    private Scanner scanner;

    public MultiplexManagementSystem() {
        this.movies = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addMovie() {
        System.out.println("Enter movie name:");
        String name = scanner.nextLine();
        System.out.println("Enter movie timing:");
        String timing = scanner.nextLine();
        System.out.println("Enter number of seats available:");
        int seatsAvailable = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        Movie movie = new Movie(name, timing, seatsAvailable);
        movies.add(movie);
        System.out.println("Movie added successfully!");
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        System.out.println("Available movies:");
        for (Movie movie : movies) {
            System.out.println("Name: " + movie.getName() + ", Timing: " + movie.getTiming() + ", Seats Available: " + movie.getSeatsAvailable());
        }
    }

    public void bookTicket() {
        System.out.println("Enter movie name:");
        String name = scanner.nextLine();
        Movie movie = findMovie(name);
        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }

        System.out.println("Enter number of seats to book:");
        int seatsToBook = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        if (seatsToBook > movie.getSeatsAvailable()) {
            System.out.println("Not enough seats available.");
            return;
        }

        movie.setSeatsAvailable(movie.getSeatsAvailable() - seatsToBook);
        System.out.println("Ticket booked successfully!");
    }

    private Movie findMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public void run() {
        while (true) {
            System.out.println("1. Add movie");
            System.out.println("2. Display movies");
            System.out.println("3. Book ticket");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    displayMovies();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        MultiplexManagementSystem system = new MultiplexManagementSystem();
        system.run();
    }
}