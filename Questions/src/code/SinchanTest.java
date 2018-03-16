package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

public class SinchanTest {
	
	public static String mergeStrings(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		if (b == null) {
			return a;
		}
		if(a == null) {
			return b;
		}
		while (i < a.length() && j < b.length()) {
			sb.append(a.charAt(i++));
			sb.append(b.charAt(j++));
		}
		while ( i < a.length()) {
			sb.append(a.charAt(i++));
		}
		while(j < b.length()) {
			sb.append(b.charAt(j++));
		}
		
		return sb.toString();
	}
	
	public class MovieResponse {
		int page;
		int per_page;
		int total;
		int total_pages;
		List<Movie> data;	
	}
	
	public class Movie {
		String Poster;
		String Title;
		String Type;
		int Year;
		String imdbID;
	}
	
	public static String[] getMovieTitles(String substring)  {
		String baseUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
		String reqUrl = baseUrl+substring;

		MovieResponse response = getMovieResponse(reqUrl);
		int total_pages = response.total_pages;
		
		List<String> titles = new ArrayList<>();
		for (int i = 1; i <= total_pages; i++) {
			String requestUrl = reqUrl + "&page="+i;
			MovieResponse responseForPagei = getMovieResponse(requestUrl);
			putTitles(titles, responseForPagei);
		}
		Collections.sort(titles);
		return  titles.toArray(new String[0]);
		
	}
	
	private static MovieResponse getMovieResponse(String reqUrl) {
		MovieResponse movieResponse = null;
		try {
		URL obj = new URL(reqUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
	//	System.out.println(response.toString());
		Gson g = new Gson();
		movieResponse = g.fromJson(response.toString(), MovieResponse.class);
		} catch (Exception e) {
			
		}
		return movieResponse;
	}
		
	
	private static void putTitles(List<String> titles, MovieResponse response) {
		for(Movie movie: response.data) {
			titles.add(movie.Title);
		}
	}
	
	public static void main(String args[]) throws Exception {
		String a = "ab";
		String b = "zsd";
		//System.out.println(SinchanTest.mergeStrings(a, b));
		String[] titles = SinchanTest.getMovieTitles("spiderman");
		System.out.println(Arrays.toString(titles));
	}
}
