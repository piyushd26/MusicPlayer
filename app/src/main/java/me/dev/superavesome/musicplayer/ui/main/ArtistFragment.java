package me.dev.superavesome.musicplayer.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.data.local.LocalDataSource;
import me.dev.superavesome.musicplayer.model.Song;

/**
 */
public class ArtistFragment extends Fragment {

  @Bind(R.id.rv_artist) RecyclerView rvArtist;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_artist, container, false);
    ButterKnife.bind(this, view);

    rvArtist.setLayoutManager(new LinearLayoutManager(getActivity()));

    LocalDataSource dataSource = new LocalDataSource(getActivity());

    final List<Song> songs = dataSource.getAllSongs();
    final ArtistAdapter adapter = new ArtistAdapter(songs);
    rvArtist.setAdapter(adapter);
    return view;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  class ArtistAdapter extends RecyclerView.Adapter<SongVH> {
    private final List<Song> songs;

    public ArtistAdapter(List<Song> songs) {
      this.songs = songs;
    }

    @Override public SongVH onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(parent.getContext());
      View view = inflater.inflate(R.layout.item_song, parent, false);
      return new SongVH(view);
    }

    @Override public void onBindViewHolder(SongVH holder, int position) {
      holder.txtArtist.setText(songs.get(position).getArtist());
      holder.txtTitle.setText(songs.get(position).getTitle());
    }

    @Override public int getItemCount() {
      return songs.size();
    }
  }

  static class SongVH extends RecyclerView.ViewHolder {
    @Bind(R.id.imageView) ImageView imageView;
    @Bind(R.id.txt_title) TextView txtTitle;
    @Bind(R.id.txt_artist) TextView txtArtist;

    public SongVH(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}