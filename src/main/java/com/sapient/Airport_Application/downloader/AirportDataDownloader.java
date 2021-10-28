package com.sapient.Airport_Application.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AirportDataDownloader {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request=HttpRequest.newBuilder(new URI("https://ourairports.com/data/airports.csv"))
				.GET()
				.timeout(Duration.ofMinutes(1))
				.build();
		HttpResponse<String> response=HttpClient.newHttpClient()
				.send(request,HttpResponse.BodyHandlers.ofString());

		BufferedReader reader=new BufferedReader(new StringReader(response.body()));
		String line="";
		List<String> airports= new ArrayList<>();
		while((line=reader.readLine())!=null) {
			airports.add(line.replace("\"",""));
		}

		List<String> small_airports=airports
				.stream()
				.filter(airport->airport.contains("small_airport"))
				.collect(Collectors.toList());
		System.out.println(small_airports);
		
		List<String> large_airports=airports
				.stream()
				.filter(airport->airport.contains("large_airport"))
				.collect(Collectors.toList());
		
		List<String> medium_airports=airports
				.stream()
				.filter(airport->airport.contains("medium_airport"))
				.collect(Collectors.toList());
	}
}
