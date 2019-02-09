package com.hai.jedi.dragdrop;

public interface ItemTouchHelperContract {
    void onRowMoved(int fromPosition, int toPosition);
    void onRowSelected(RecyclerViewAdapter.MyViewHolder myViewHolder);


}
