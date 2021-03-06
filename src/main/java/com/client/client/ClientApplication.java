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
        Scanner choose = new Scanner(System.in);

            System.out.println("Members or Memberships or Membership (Types) or Tournaments or (Current) Tournaments or (Past) Tournament or (Upcoming) Tournaments?");
            String userinput1 = choose.nextLine();
            if (userinput1.toUpperCase().equals("MEMBERS")) {
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
                                membersPostRequest(firstName, lastName, address, email, phone);

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
                                membersPutRequest(firstName, lastName, address, email, phone);

                            }  else if (userinput1.toUpperCase().equals("D")) {
                                membershipDeleteRequest();

                            } else {
                                System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                            }
            } else if (userinput1.toUpperCase().equals("TOURNAMENTS")) {
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
                    
            } else if (userinput1.toUpperCase().equals("MEMBERSHIPS")) {
                if (userinput1.toUpperCase().equals("A")) {
                    System.out.println("Enter a start date (dd/mm/yyyy): ");
                    String startDate = choose.nextLine();
                    System.out.println("Enter a duration (hh-mm-ss): ");
                    String duration = choose.nextLine();
                    membershipPostRequest(startDate, duration);
                
                } else if (userinput1.toUpperCase().equals("E")) {
                    System.out.println("Enter a start date (dd/mm/yyyy): ");
                    String startDate = choose.nextLine();
                    System.out.println("Enter a duration (hh-mm-ss): ");
                    String duration = choose.nextLine();
                    membershipPostRequest(startDate, duration);
                
                }  else if (userinput1.toUpperCase().equals("D")) {
                    membershipDeleteRequest();
                
                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                } 
            } else if (userinput1.toUpperCase().equals("TYPE")) {
                if (userinput1.toUpperCase().equals("A")) {
                    System.out.println("Enter a plan: ");
                    String plan = choose.nextLine();
                    System.out.println("Enter a type: ");
                    String type = choose.nextLine();
                    membershiptypePostRequest(plan, type);
                
                } else if (userinput1.toUpperCase().equals("E")) {
                    System.out.println("Enter a plan: ");
                    String plan = choose.nextLine();
                    System.out.println("Enter a type: ");
                    String type = choose.nextLine();
                    membershiptypePutRequest(plan, type);
                
                }  else if (userinput1.toUpperCase().equals("D")) {
                    membershipDeleteRequest();
                
                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                } 
            } else if (userinput1.toUpperCase().equals("PAST")) {
                if (userinput1.toUpperCase().equals("A")) {
                    System.out.println("Enter a date (dd/mm/yyyy): ");
                    String date = choose.nextLine();
                    pasttournamentPutRequest(date);
                
                } else if (userinput1.toUpperCase().equals("E")) {
                    System.out.println("Enter a date (dd/mm/yyyy): ");
                    String date = choose.nextLine();
                    pasttournamentPutRequest(date);
                
                }  else if (userinput1.toUpperCase().equals("D")) {
                    membershipDeleteRequest();
                
                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                } 
            } else if (userinput1.toUpperCase().equals("CURRENT")) {
                if (userinput1.toUpperCase().equals("A")) {
                    System.out.println("Enter a date (dd/mm/yyyy): ");
                    String date = choose.nextLine();
                    currenttournamentPostRequest(date);
                
                } else if (userinput1.toUpperCase().equals("E")) {
                    System.out.println("Enter a date (dd/mm/yyyy): ");
                    String date = choose.nextLine();
                    currenttournamentPostRequest(date);
                
                }  else if (userinput1.toUpperCase().equals("D")) {
                    membershipDeleteRequest();
                
                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                }
            } else if (userinput1.toUpperCase().equals("UPCOMING")) {
                if (userinput1.toUpperCase().equals("A")) {
                    System.out.println("Enter a date (dd/mm/yyyy): ");
                    String date = choose.nextLine();
                    upcomingtournamentPostRequest(date);
                
                } else if (userinput1.toUpperCase().equals("E")) {
                    System.out.println("Enter a date (dd/mm/yyyy): ");
                    String date = choose.nextLine();
                    upcomingtournamentPostRequest(date);
                
                }  else if (userinput1.toUpperCase().equals("D")) {
                    membershipDeleteRequest();
                
                } else {
                    System.out.println("Please enter either \"(A)dd\", \"(E)dit\" \"(D)elete\"");
                }  
            }              
            else {
                System.out.println("Please enter either \"M\" or \"T\"");
            }

    }

    /////////////////////////////////////////////// MEMBERS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static void membersGetRequest() throws IOException, InterruptedException {
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

        public static void membersPostRequest(String firstName, String lastName, String address, String email, int phone) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("first_name", firstName);
            data.put("last_name", lastName);
            data.put("address", address);
            data.put("email", email);
            data.put("phone", phone);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/members"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

    public static void membersPutRequest(String firstName, String lastName, String address, String email, int phone) throws IOException, InterruptedException{
        String id;
        Scanner idInput = new Scanner(System.in);
        System.out.println("Enter the id you want to edit: ");
        id = idInput.nextLine();
        idInput.close();

        Map<Object, Object> data = new HashMap<>();
        data.put("first_name", firstName);
        data.put("last_name", lastName);
        data.put("address", address);
        data.put("email", email);
        data.put("phone", phone);

        ObjectMapper dataMapper = new ObjectMapper();
        String stringifydataMapper = dataMapper.writeValueAsString(data);

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/members/" + id))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Updated : " + responseBody);
    }

    public static void membersDeleteRequest() throws IOException, InterruptedException{
        String id;
        Scanner idInput = new Scanner(System.in);
        System.out.println("Enter the id you want to edit: ");
        id = idInput.nextLine();
        idInput.close();

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/members/" + id))
                .version(HttpClient.Version.HTTP_2)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Deleted " + responseBody);
    }

    /////////////////////////////////////////////// MEMBERSHIP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static void membershipGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/membership")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void membershipPostRequest(String startDate, String duration) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("startDate", startDate);
            data.put("duration", duration);

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

        public static void membershipPutRequest(String startDate, String duration) throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            Map<Object, Object> data = new HashMap<>();
            data.put("startDate", startDate);
            data.put("duration", duration);
    
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

    /////////////////////////////////////////////// MEMBERSHIPTYPE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static void membershiptypeGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/membershiptype")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void membershiptypePostRequest(String plan, String type) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("plan", plan);
            data.put("type", type);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membershiptype"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

        public static void membershiptypePutRequest(String plan, String type) throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            Map<Object, Object> data = new HashMap<>();
            data.put("plan", plan);
            data.put("type", type);
    
            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membershiptype/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Updated : " + responseBody);
        }

        public static void membershiptypeDeleteRequest() throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/membershiptype/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Deleted " + responseBody);
        }

    /////////////////////////////////////////////// TOURNAMENT \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

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

    /////////////////////////////////////////////// CURRENT \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static void currenttournamentGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/currenttournament")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void currenttournamentPostRequest(String date) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("date", date);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/currenttournament"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

        public static void currenttournamentPutRequest(String date) throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            Map<Object, Object> data = new HashMap<>();
            data.put("date", date);
    
            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/currenttournament/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Updated : " + responseBody);
        }

        public static void currenttournamentDeleteRequest() throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/currenttournament/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Deleted " + responseBody);
        }

    /////////////////////////////////////////////// PAST \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static void pasttournamentGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/pasttournament")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pasttournamentPostRequest(String date) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("date", date);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/pasttournament"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

        public static void pasttournamentPutRequest(String date) throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            Map<Object, Object> data = new HashMap<>();
            data.put("date", date);
    
            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/pasttournament/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Updated : " + responseBody);
        }

        public static void pasttournamentDeleteRequest() throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/pasttournament/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Deleted " + responseBody);
        }

    /////////////////////////////////////////////// UPCOMING \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static void upcomingtournamentGetRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/upcomingtournament")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void upcomingtournamentPostRequest(String date) throws IOException, InterruptedException {
            Map<Object, Object> data = new HashMap<>();
            data.put("date", date);

            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/upcomingtournament"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Added: " + responseBody);
        }

        public static void upcomingtournamentPutRequest(String date) throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            Map<Object, Object> data = new HashMap<>();
            data.put("date", date);
    
            ObjectMapper dataMapper = new ObjectMapper();
            String stringifydataMapper = dataMapper.writeValueAsString(data);
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/upcomingtournament/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(stringifydataMapper))
                    .build();
    
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Updated : " + responseBody);
        }

        public static void upcomingtournamentDeleteRequest() throws IOException, InterruptedException{
            String id;
            Scanner idInput = new Scanner(System.in);
            System.out.println("Enter the id you want to edit: ");
            id = idInput.nextLine();
            idInput.close();
    
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/upcomingtournament/" + id))
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
