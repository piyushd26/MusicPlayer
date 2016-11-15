package me.dev.superavesome.musicplayer.ui.albumList;

import java.util.List;

import javax.inject.Inject;

import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;
import me.dev.superavesome.musicplayer.model.Album;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

import static me.dev.superavesome.musicplayer.utils.Preconditions.checkNotNull;
import static me.dev.superavesome.musicplayer.utils.RxUtils.unSubscribe;

/**
 * Created by vardansharma on 15/11/16.
 */
public class AlbumListPresenter implements AlbumListContract.Presenter {

    private GetAllAlbumsUseCase getAllAlbumsUseCaseUseCase;
    private AlbumListContract.View view;
    private CompositeSubscription subscription;

    @Inject
    public AlbumListPresenter(AlbumListContract.View view, GetAllAlbumsUseCase useCase) {
        this.getAllAlbumsUseCaseUseCase = checkNotNull(useCase, "usecase is null");
        this.view = checkNotNull(view, "view is null");
        subscription = new CompositeSubscription();
    }

    @Override
    public void getAlbums() {
        subscription.add(getAllAlbumsUseCaseUseCase.getAlbumList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Album>>() {
                    @Override
                    public void call(List<Album> albumList) {
                        view.showAlbums(albumList);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Timber.e(throwable.getMessage());
                        view.showEmptyScreen();
                    }
                }));
    }


    @Override
    public void detachFromUi() {
        unSubscribe(subscription);
    }
}
