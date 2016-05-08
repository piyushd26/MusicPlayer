/*
 * Copyright 2016 Substance Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.dev.superavesome.musicplayer.model;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

/**
 * Created by Adrian on 7/5/2015.
 */
public class Playlist extends MediaObject {
  private final List<Song> songs;
  private final String name;
  private final long id;
  private final int type;

  private Playlist(Builder builder) {
    data = builder.data;
    id = builder.id;
    locked = builder.locked;
    setPosInList(builder.posInList);
    songs = builder.songs;
    name = builder.name;
    type = builder.type;
  }

  @Override protected Uri getBaseUri() {
    return MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;
  }

  public String getName() {
    return name;
  }

  public List<Song> getSongs() {
    return songs;
  }

  public void addSong(Song s) {
    getSongs().add(s);
  }

  public void removeSong(Song s) {
    getSongs().remove(s);
  }

  public void addAll(List<Song> songs) {
    for (Song s : songs) addSong(s);
  }

  public void removeAll(List<Song> songs) {
    for (Song s : songs) removeSong(s);
  }

  public long getId() {
    return id;
  }

  public int getType() {
    return type;
  }

  public static final class Builder {
    private MediaMetadataCompat data;
    private long id;
    private final int type;
    private boolean locked;
    private int posInList;
    private final List<Song> songs;
    private final String name;

    public Builder(List<Song> songs, String name, long id, int type) {
      this.songs = songs;
      this.name = name;
      this.id = id;
      this.type = type;
    }

    public Builder data(MediaMetadataCompat val) {
      data = val;
      return this;
    }

    public Builder id(long val) {
      id = val;
      return this;
    }

    public Builder locked(boolean val) {
      locked = val;
      return this;
    }

    public Builder posInList(int val) {
      posInList = val;
      return this;
    }

    public Playlist build() {
      return new Playlist(this);
    }
  }
}
