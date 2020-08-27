package src.com.hipsandy.problems;

import java.util.*;

public class TopKMovies {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String[][] movieRelationships = new String[][]{{"m1", "m5", "m6", "m7"}, {"m5", "m13", "m14"}, {"m14", "m50"}, {"m3", "m10", "m20"}};
    Map<String, Double> ratings = getRatings(new String[][]{{"m1", "9.0"}, {"m5", "8.5"}, {"m6", "9.1"}, {"m7", "6.3"}, {"m13", "4.7"}, {"m14", "8.2"}, {"m50", "8.9"}});
    System.out.println(solution.findTopKMoviesLike(3, "m1", movieRelationships, ratings, true));


  }

  private static Map<String, Double> getRatings(String[][] ratingsArr) {
    Map<String, Double> ratings = new HashMap<>();
    for (int r = 0; r < ratingsArr.length; r++) {
      ratings.put(ratingsArr[r][0], Double.valueOf(ratingsArr[r][1]));
    }
    return ratings;
  }

  static class Movie implements Comparable<Movie> {
    String id;
    Double rating;
    boolean visited;

    @Override
    public int compareTo(Movie o) {
      return o.rating.compareTo(this.rating);
    }

    @Override
    public String toString() {
      return id + " - " + rating;
    }
  }

  static class Solution {

    public Set<Movie> findTopKMoviesLike(int k, String m, String[][] movieRelationships, Map<String, Double> ratings, boolean isDirectlyRelated) {
      // Get a list of all movies related to m
      Set<Movie> relatedMovies = getRelatedMovies(m, movieRelationships, ratings, isDirectlyRelated);

      // Ensure they're sorted by ratings - TODO: Use TreeSet that way it should be sorted by rating
//      Collections.sort(relatedMovies);

      // return the first k
      Set<Movie> result = new TreeSet<>();

      for (Movie movie : relatedMovies) {
        result.add(movie);
        if (result.size() == k) {
          return result;
        }
      }

      return result;

    }

    // TODO: Implement scenario where even indirectly related movies are to be considered
    private Set<Movie> getRelatedMovies(String m, String[][] movieRelationships, Map<String, Double> ratings, boolean isDirectlyRelated) {
//      List<Movie> relatedMovies = new ArrayList<>();
      Set<Movie> relatedMovies = new LinkedHashSet<>();
      // go through the first column and get only directly related movies
      for (int r = 0; r < movieRelationships.length; r++) {
        String movie = movieRelationships[r][0];
        if (movie != null && movie.equalsIgnoreCase(m)) {
          for (int c = 1; c < movieRelationships[r].length; c++) {
            Movie related = new Movie();
            related.id = movieRelationships[r][c];
            related.rating = ratings.get(related.id);
            relatedMovies.add(related);
          }
        }
      }

      return relatedMovies;
    }

  }

}



