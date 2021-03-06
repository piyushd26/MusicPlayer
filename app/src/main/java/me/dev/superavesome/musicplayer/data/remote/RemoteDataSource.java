package me.dev.superavesome.musicplayer.data.remote;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Album;
import me.dev.superavesome.musicplayer.model.Artist;
import me.dev.superavesome.musicplayer.model.Genre;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */

public class RemoteDataSource implements DataSource {
    @Override
    public Observable<List<Song>> getAllSongs() {
        throw new IllegalStateException("NOT YET IMPLEMENTED");

    }

    @Override
    public Observable<List<Album>> getAllAlbums() {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }

    @Override
    public Observable<List<Artist>> getAllArtist() {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }

    @Override
    public Observable<List<Song>> getAllSongsFromGenre(String genreId) {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }

    @Override
    public Observable<List<Song>> getAllSongsFromArtist(String artistId) {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }

    @Override
    public Observable<List<Song>> getAllSongsFromAlbum(String albumId) {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }
}
