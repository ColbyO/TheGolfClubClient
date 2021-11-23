package com.client.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClientApplication {

	public static void main(String[] args) {
        String keepGoing = "y";
        Scanner choose = new Scanner(System.in);

        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            try {
                System.out.println("Memberships or Tournaments?");
                String userinput1 = choose.nextLine();
                if (userinput1.toUpperCase().equals("T")) {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8080/api/tournaments"))
                            .build();
            
                    try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        if (response.statusCode()==200) {
                            System.out.println("*****" + response.body());
                            System.out.println("Do you want to keep going? (y/n)");
                            keepGoing = choose.nextLine();
                        }
            
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        }
                    } else if (userinput1.toUpperCase().equals("M")) {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create("http://localhost:8080/api/members"))
                                .build();
                
                        try {
                            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                            if (response.statusCode()==200) {
                                System.out.println("*****" + response.body());
                            }

                            System.out.println("Do you want to keep going? (y/n)");
                            keepGoing = choose.nextLine();
                
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Please enter either \"M\" or \"T\"");
                    }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        } 

}
