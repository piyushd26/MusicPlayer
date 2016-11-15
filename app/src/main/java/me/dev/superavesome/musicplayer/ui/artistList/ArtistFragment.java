package me.dev.superavesome.musicplayer.ui.artistList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.base.BaseApp;
import me.dev.superavesome.musicplayer.model.Artist;

public class ArtistFragment extends Fragment implements ArtistListContract.View {
    @Bind(R.id.rv_artists)
    RecyclerView rvArtists;

    @Inject
    ArtistListPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        ButterKnife.bind(this, view);
        rvArtists.setLayoutManager(new LinearLayoutManager(getActivity()));

        BaseApp baseApp = (BaseApp) getActivity().getApplication();
        baseApp.getApplicationComponent().inject(this);

        presenter.attachToUi(this);
        presenter.getArtistList();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        presenter.detachFromUi();
    }

    @Override
    public void showData(List<Artist> artists) {
        rvArtists.setAdapter(new ArtistAdapter(artists, getActivity()));
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
