package com.an.room.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.an.room.R;
import com.an.room.model.Note;
import com.an.room.util.AppUtils;
import com.an.room.util.NoteDiffUtil;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.CustomViewHolder> {

    private List<Note> notes;
    public NotesListAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Note note = getItem(position);
//My Notes page`inde Title ve Time`in gorunmesi burda olur
        holder.itemTitle.setText(note.getTitle());
//        SimpleDateFormat DateFor = new SimpleDateFormat("dd MMMM");
//
//        String stringDate = DateFor.format(note.getCreatedDate());

        //holder.itemTime2.setText(note.getCreatedDate().toString());
        holder.itemTime2.setText(note.getFormattedDate());
        //holder.itemTime.setText(AppUtils.getFormattedDateString(note.getCreatedAt()));


        if(note.isEncrypt()) {
            holder.itemTime.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_lock, 0);

        } else {
            holder.itemTime.setCompoundDrawablesWithIntrinsicBounds(0,0, 0, 0);
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public Note getItem(int position) {
        return notes.get(position);
    }

    public void addTasks(List<Note> newNotes) {
        NoteDiffUtil noteDiffUtil = new NoteDiffUtil(notes, newNotes);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(noteDiffUtil);
        notes.clear();
        notes.addAll(newNotes);
        diffResult.dispatchUpdatesTo(this);
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle, itemTime, itemTime2;
        public CustomViewHolder(View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.item_title);
            itemTime = itemView.findViewById(R.id.item_desc);
            itemTime2 = itemView.findViewById(R.id.item_title2);
        }
    }
}
