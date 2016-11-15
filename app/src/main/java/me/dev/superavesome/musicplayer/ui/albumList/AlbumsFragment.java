package me.dev.superavesome.musicplayer.ui.albumList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.model.Album;

/**
 */
public class AlbumsFragment extends Fragment implements AlbumListContract.View {

    @Bind(R.id.rv_albums)
    RecyclerView rvAlbums;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        ButterKnife.bind(this, view);
        final FragmentActivity activity = getActivity();

        rvAlbums.setLayoutManager(new GridLayoutManager(activity, 2));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showAlbums(List<Album> albumList) {
        final FragmentActivity activity = getActivity();
        rvAlbums.setAdapter(new AlbumAdapter(albumList, activity));
    }

    @Override
    public void showLoading() {
        //todo

    }

    @Override
    public void hideLoading() {
        //todo

    }

    @Override
    public void showEmptyScreen() {
        //todo
    }

    @Override
    public void hideEmptyScreen() {
        //todo
    }

    @Override
    public void showErrorScreen() {
        //todo
    }
}
