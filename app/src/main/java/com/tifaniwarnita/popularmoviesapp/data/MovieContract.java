package com.tifaniwarnita.popularmoviesapp.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Tifani on 5/13/2016.
 */
public class MovieContract {
    // Content authority to contact Content Provider
    public static final String CONTENT_AUTHORITY = "com.tifaniwarnita.popularmoviesapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths
    public static final String PATH_MOVIE = "movies";
    public static final String PATH_TRAILER = "trailers";
    public static final String PATH_REVIEW = "reviews";

    /* Inner class that defines the table contents of the location table */
    public static final class MovieEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;

        // Table name
        public static final String TABLE_NAME = "movie";

        // Column name
        private static final String COLUMN_MOVIE_ID = "movie_id";
        private static final String COLUMN_GENRE_ID = "genre_ids";
        private static final String COLUMN_ORIGINAL_TITLE = "original_title";
        private static final String COLUMN_TITLE = "title";
        private static final String COLUMN_ORIGINAL_LANGUAGE = "original_language";
        private static final String COLUMN_ADULT = "adult"; //boolean
        private static final String COLUMN_OVERVIEW = "overview";
        private static final String COLUMN_RELEASE_DATE = "release_date";
        private static final String COLUMN_POSTER_PATH = "poster_path";
        private static final String COLUMN_BACKDROP_PATH = "backdrop_path";
        private static final String COLUMN_POPULARITY = "popularity";
        private static final String COLUMN_VOTE_COUNT = "vote_count";
        private static final String COLUMN_VOTE_AVERAGE = "vote_average";
        private static final String COLUMN_VIDEO = "video"; //boolean

        public static Uri buildMovieWithId(long id) {
            return ContentUris
                    .withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildMovieWithPoster(String posterPath) {
            return CONTENT_URI.buildUpon()
                    .appendPath(posterPath)
                    .build();
        }

        public static long getIdFromUri(Uri uri) {
            return ContentUris.parseId(uri);
        }

        public static String getPosterPathFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}
