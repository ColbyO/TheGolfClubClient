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
        String keepGoing = "y";
        Scanner choose = new Scanner(System.in);

        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            System.out.println("Memberships or Tournaments?");
            String userinput1 = choose.nextLine();
            if (userinput1.toUpperCase().equals("M")) {
                membershipGetRequest();
                            System.out.println("Do you want to Add/Edit/Delete Memberships? (A/E/D)");
                            userinput1 = choose.nextLine();
                            if (userinput1.toUpperCase().equals("A")) {
                                membershipPostRequest();
                                System.out.println("Do you want to keep going? (y/n)");
                                keepGoing = choose.nextLine();
                            } else if (userinput1.toUpperCase().equals("E")) {
                                membershipPutRequest();
                                System.out.println("Do you want to keep going? (y/n)");
                                keepGoing = choose.nextLine();
                            }  else if (userinput1.toUpperCase().equals("D")) {
                                membershipDeleteRequest();
                                System.out.println("Do you want to keep going? (y/n)");
                                keepGoing = choose.nextLine();
                            } else {
                                System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                            }
            } else if (userinput1.toUpperCase().equals("T")) {
                tournamentGetRequest();
                System.out.println("Do you want to Add/Edit/Delete Memberships? (A/E/D)");
                userinput1 = choose.nextLine();
                if (userinput1.toUpperCase().equals("A")) {
                    tournamentPostRequest();
                    System.out.println("Do you want to keep going? (y/n)");
                    keepGoing = choose.nextLine();
                } else if (userinput1.toUpperCase().equals("E")) {
                    tournamentPutRequest();
                    System.out.println("Do you want to keep going? (y/n)");
                    keepGoing = choose.nextLine();
                }  else if (userinput1.toUpperCase().equals("D")) {
                    tournamentDeleteRequest();
                    System.out.println("Do you want to keep going? (y/n)");
                    keepGoing = choose.nextLine();
                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                }
            } else {
                System.out.println("Please enter either \"M\" or \"T\"");
            }
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

    public static void membershipPostRequest() throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("firstName", "Jane");
            data.put("lastName", "Doe");
            data.put("address", "111 Street");
            data.put("email", "test@test.com");
            data.put("phone", 123456);
            data.put("duration", "duration test");
            data.put("membershipType", "GOLD");
            data.put("currentTournaments", "3");
            data.put("pastTournaments", "3");
            data.put("upcomingTournaments", "new");
            data.put("finalStandings", "36th");
            data.put("location", "St. John's");
            data.put("participationMembers", "Double D");

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

        public static void tournamentPostRequest() throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("startDate", "Feb");
            data.put("endDate", "March");
            data.put("fee", 25);
            data.put("prize", 60);
            data.put("participating", "123");
            data.put("standings", "111");

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

    public static void membershipPutRequest() throws IOException, InterruptedException{
        Map<Object, Object> data = new HashMap<>();
        data.put("firstName", "Jane");
        data.put("lastName", "Doe");
        data.put("address", "111 Street");
        data.put("email", "test@test.com");
        data.put("phone", 123456);
        data.put("duration", "duration test");
        data.put("membershipType", "GOLD");
        data.put("currentTournaments", "3");
        data.put("pastTournaments", "3");
        data.put("upcomingTournaments", "new");
        data.put("finalStandings", "36th");
        data.put("location", "St. John's");
        data.put("participationMembers", "Double D");

        ObjectMapper dataMapper = new ObjectMapper();
        String stringifydataMapper = dataMapper.writeValueAsString(data);

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membership/2"))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Updated : " + responseBody);
    }

    public static void tournamentPutRequest() throws IOException, InterruptedException{
        Map<Object, Object> data = new HashMap<>();
        data.put("startDate", "Jan");
        data.put("endDate", "Dec");
        data.put("fee", 12);
        data.put("prize", 35);
        data.put("participating", "123456");
        data.put("standings", "standing test");

        ObjectMapper dataMapper = new ObjectMapper();
        String stringifydataMapper = dataMapper.writeValueAsString(data);

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membership/2"))
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
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/Membership/3"))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Deleted: " + responseBody);
    }

    public static void tournamentDeleteRequest() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/tournament/2"))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Deleted: " + responseBody);
    }

}
