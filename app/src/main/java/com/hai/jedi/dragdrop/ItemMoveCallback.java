package com.hai.jedi.dragdrop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemMoveCallback extends ItemTouchHelper.Callback{

    private final ItemTouchHelperContract mAdapter;

    // We have to initialize our interface.
    public ItemMoveCallback(ItemTouchHelperContract adapter){
        mAdapter = adapter;
    }

    /*ItemTouchHelper.Call back methods*/
    @Override
    public boolean isLongPressDragEnabled(){
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled(){
        // Todo - Enable this after to see if it enables swipe.
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int index){
        //Todo - Add this swipe functionality after we get he drag working.
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder){
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // Todo - Add swipe functionality here and add it to the method below.
        return makeMovementFlags(dragFlag, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder target) {
        mAdapter.onRowMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState){
        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            if(viewHolder instanceof MyViewHolder) {
                MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
                mAdapter.onRowSelected(myViewHolder);
            }
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder){
        super.clearView(recyclerView, viewHolder);

        if(viewHolder instanceof MyViewHolder){
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            mAdapter.onRowClear(myViewHolder);

        }
    }
}
