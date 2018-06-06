package com.mnm.jam.mnmdemo.ui.movies.adapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.mnm.jam.mnmdemo.ui.main.MainActivity;


/**
 *  @author Javi 05/06/2018
 *
 *  Scroll to manage events on RecyclerView
 *  <p>
 *  This class is used by {@link MainActivity} in order to get the scroll RecycleView events
 *
 */
public abstract class ScrollRecyclerView extends RecyclerView.OnScrollListener {

    StaggeredGridLayoutManager layoutManager;
    private int end = 0;
    private int page = 1;
    private int mOffset = 0;

    public ScrollRecyclerView(StaggeredGridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();

        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPositions(null)[1] + 1;

        int position = firstVisibleItemPosition+visibleItemCount;
        int limit = totalItemCount - mOffset;

        // Check if bottom has been reached
        if (position >= limit && totalItemCount > end) {

            loadMoreItems(page);
            end = totalItemCount;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    protected abstract void loadMoreItems(int page);

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();
}