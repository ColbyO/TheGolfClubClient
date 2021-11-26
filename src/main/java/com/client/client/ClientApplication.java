package com.client.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        // String keepGoing = "y";
        Scanner choose = new Scanner(System.in);

            System.out.println("Memberships or Tournaments?");
            String userinput1 = choose.nextLine();
            if (userinput1.toUpperCase().equals("M")) {
                membershipGetRequest();
                            System.out.println("Do you want to Add/Edit/Delete Memberships? (A/E/D)");
                            userinput1 = choose.nextLine();
                            if (userinput1.toUpperCase().equals("A")) {
                                System.out.println("Enter a first name: ");
                                String firstName = choose.nextLine();
                                System.out.println("Enter a last name: ");
                                String lastName = choose.nextLine();
                                System.out.println("Enter a address: ");
                                String address = choose.nextLine();
                                System.out.println("Enter a email: ");
                                String email = choose.nextLine();
                                System.out.println("Enter a phone: ");
                                int phone = choose.nextInt();
                                System.out.println("Enter a duration: ");
                                String duration = choose.nextLine();
                                System.out.println("Enter a Membership Type: ");
                                String membershipType = choose.nextLine();
                                System.out.println("Enter a Current Tournament: ");
                                String currentTournament = choose.nextLine();
                                System.out.println("Enter a Past Tournament: ");
                                String pastTournament = choose.nextLine();
                                System.out.println("Enter a Upcoming Tournament: ");
                                String upcomingTournament = choose.nextLine();
                                System.out.println("Enter a Final Standings: ");
                                String finalStandings = choose.nextLine();
                                System.out.println("Enter a Location: ");
                                String location = choose.nextLine();
                                System.out.println("Enter a Participation Members: ");
                                String participationMembers = choose.nextLine();
                                membershipPostRequest(firstName, lastName, address, email, phone, duration, membershipType, currentTournament, pastTournament, upcomingTournament, finalStandings, location, participationMembers);

                            } else if (userinput1.toUpperCase().equals("E")) {
                                System.out.println("Enter a first name: ");
                                String firstName = choose.nextLine();
                                System.out.println("Enter a last name: ");
                                String lastName = choose.nextLine();
                                System.out.println("Enter a address: ");
                                String address = choose.nextLine();
                                System.out.println("Enter a email: ");
                                String email = choose.nextLine();
                                System.out.println("Enter a phone: ");
                                int phone = choose.nextInt();
                                System.out.println("Enter a duration: ");
                                String duration = choose.nextLine();
                                System.out.println("Enter a Membership Type: ");
                                String membershipType = choose.nextLine();
                                System.out.println("Enter a Current Tournament: ");
                                String currentTournament = choose.nextLine();
                                System.out.println("Enter a Past Tournament: ");
                                String pastTournament = choose.nextLine();
                                System.out.println("Enter a Upcoming Tournament: ");
                                String upcomingTournament = choose.nextLine();
                                System.out.println("Enter a Final Standings: ");
                                String finalStandings = choose.nextLine();
                                System.out.println("Enter a Location: ");
                                String location = choose.nextLine();
                                System.out.println("Enter a Participation Members: ");
                                String participationMembers = choose.nextLine();
                                membershipPutRequest(firstName, lastName, address, email, phone, duration, membershipType, currentTournament, pastTournament, upcomingTournament, finalStandings, location, participationMembers);

                            }  else if (userinput1.toUpperCase().equals("D")) {
                                membershipDeleteRequest();

                            } else {
                                System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                            }
            } else if (userinput1.toUpperCase().equals("T")) {
                tournamentGetRequest();
                System.out.println("Do you want to Add/Edit/Delete Memberships? (A/E/D)");
                userinput1 = choose.nextLine();
                if (userinput1.toUpperCase().equals("A")) {
                    System.out.println("Enter a Start Date: ");
                    String startDate = choose.nextLine();
                    System.out.println("Enter a End Date: ");
                    String endDate = choose.nextLine();
                    System.out.println("Enter a fee: ");
                    double fee = choose.nextDouble();
                    System.out.println("Enter a prize pool: ");
                    double prize = choose.nextDouble();
                    System.out.println("Enter participating members: ");
                    String participating = choose.nextLine();
                    System.out.println("Enter standings: ");
                    String standings = choose.nextLine();
                    tournamentPostRequest(startDate, endDate, fee, prize, participating, standings);

                } else if (userinput1.toUpperCase().equals("E")) {
                    System.out.println("Enter a new Start Date: ");
                    String startDate = choose.nextLine();
                    System.out.println("Enter a new End Date: ");
                    String endDate = choose.nextLine();
                    System.out.println("Enter a new Fee: ");
                    double fee = choose.nextDouble();
                    System.out.println("Enter a new Prize Pool: ");
                    double prize = choose.nextDouble();
                    System.out.println("Enter new Participating Members: ");
                    String participating = choose.nextLine();
                    System.out.println("Enter new standings: ");
                    String standings = choose.nextLine();
                    tournamentPutRequest(startDate, endDate, fee, prize, participating, standings);

                }  else if (userinput1.toUpperCase().equals("D")) {
                    tournamentDeleteRequest();

                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                }
            } else {
                System.out.println("Please enter either \"M\" or \"T\"");
            }

    }

    public static void membershipGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/members")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tournamentGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/tournaments")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void membershipPostRequest(String firstName, String lastName, String address, String email, int phone, String duration, String membershipType, 
    String currentTournaments, String pastTournaments, String upcomingTournaments, String finalStandings, String location, String participationMembers) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("firstName", firstName);
            data.put("lastName", lastName);
            data.put("address", address);
            data.put("email", email);
            data.put("phone", phone);
            data.put("duration", duration);
            data.put("membershipType", membershipType);
            data.put("currentTournaments", currentTournaments);
            data.put("pastTournaments", pastTournaments);
            data.put("upcomingTournaments", upcomingTournaments);
            data.put("finalStandings", finalStandings);
            data.put("location", location);
            data.put("participationMembers", participationMembers);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membership"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

        public static void tournamentPostRequest(String startDate, String endDate, double fee, double prize, String participating, String standings) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("startDate", startDate);
            data.put("endDate", endDate);
            data.put("fee", fee);
            data.put("prize", prize);
            data.put("participating", participating);
            data.put("standings", standings);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/tournament"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

    public static void membershipPutRequest(String firstName, String lastName, String address, String email, int phone, String duration, String membershipType, 
    String currentTournaments, String pastTournaments, String upcomingTournaments, String finalStandings, String location, String participationMembers) throws IOException, InterruptedException{
        String id;
        Scanner idInput = new Scanner(System.in);
        System.out.println("Enter the id you want to edit: ");
        id = idInput.nextLine();
        idInput.close();

        Map<Object, Object> data = new HashMap<>();
        data.put("firstName", firstName);
        data.put("lastName", lastName);
        data.put("address", address);
        data.put("email", email);
        data.put("phone", phone);
        data.put("duration", duration);
        data.put("membershipType", membershipType);
        data.put("currentTournaments", currentTournaments);
        data.put("pastTournaments", pastTournaments);
        data.put("upcomingTournaments", upcomingTournaments);
        data.put("finalStandings", finalStandings);
        data.put("location", location);
        data.put("participationMembers", participationMembers);

        ObjectMapper dataMapper = new ObjectMapper();
        String stringifydataMapper = dataMapper.writeValueAsString(data);

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membership/" + id))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Updated : " + responseBody);
    }

    public static void tournamentPutRequest(String startDate, String endDate, double fee, double prize, String participating, String standings) throws IOException, InterruptedException{
        String id;
        Scanner idInput = new Scanner(System.in);
        System.out.println("Enter the id you want to edit: ");
        id = idInput.nextLine();
        idInput.close();

        Map<Object, Object> data = new HashMap<>();
        data.put("startDate", startDate);
        data.put("endDate", endDate);
        data.put("fee", fee);
        data.put("prize", prize);
        data.put("participating", participating);
        data.put("standings", standings);

        ObjectMapper dataMapper = new ObjectMapper();
        String stringifydataMapper = dataMapper.writeValueAsString(data);

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membership/" + id))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Updated : " + responseBody);
    }

    public static void membershipDeleteRequest() throws IOException, InterruptedException{
        String id;
        Scanner idInput = new Scanner(System.in);
        System.out.println("Enter the id you want to edit: ");
        id = idInput.nextLine();
        idInput.close();

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/Membership/" + id))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Deleted " + responseBody);
    }

    public static void tournamentDeleteRequest() throws IOException, InterruptedException{
        String id;
        Scanner idInput = new Scanner(System.in);
        System.out.println("Enter the id you want to edit: ");
        id = idInput.nextLine();
        idInput.close();

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/tournament/" + id))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Deleted " + responseBody);
    }

}
