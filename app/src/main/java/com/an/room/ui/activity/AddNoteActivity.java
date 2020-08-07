package com.an.room.ui.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.an.room.AppConstants;
import com.an.room.R;
import com.an.room.model.Note;
import com.an.room.util.AppUtils;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener, AppConstants {

    private EditText editTitle;
    private EditText editTitle2;
    private TextView textTime, btnSave;
    private Button Date;
    public Date date;
    private AppCompatCheckBox checkBox;
    public String stringDate;
    //private ImageView btnDelete;

    private Note note;
//    private boolean pwdVisible;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        //textTime = findViewById(R.id.text_time);
        //toolbarTitle = findViewById(R.id.title);
        editTitle = findViewById(R.id.edit_title);
        editTitle2 = findViewById(R.id.edit_title2);
        //editDesc = findViewById(R.id.edit_desc);
        Date = findViewById(R.id.date);
        Date currentDate = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd MMM");
        String stringCurrentDate = DateFor.format(currentDate);
        Date.setText("Date: " + stringCurrentDate);

        Button startTime = findViewById(R.id.startTime);
        SimpleDateFormat timeFor = new SimpleDateFormat("HH:mm");
        String stringCurrentTime = timeFor.format(currentDate);
        startTime.setText("Start Time: "+ stringCurrentTime);

        Button endTime = findViewById(R.id.endTime);
        Date oneHourLater = new Date(System.currentTimeMillis() + 3600 * 1000);
        timeFor = new SimpleDateFormat("HH:mm");
        String stringOneHourLater = timeFor.format(oneHourLater);
        endTime.setText("End Time: "+ stringOneHourLater);
        btnSave = findViewById(R.id.save);
        btnSave.setOnClickListener(this);

       Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker((Button) v);
            }
        });
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker((Button) v);
            }
        });
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker((Button)v);
            }
        });
        //editPwd = findViewById(R.id.edit_pwd);
        //editPwd.setOnTouchListener(this);

        //checkBox = findViewById(R.id.checkbox);
        //checkBox.setOnCheckedChangeListener(this);

        //btnDelete = findViewById(R.id.btn_close);
        //btnDelete.setOnClickListener(this);

        //btnDone = findViewById(R.id.btn_done);
        //btnDone.setOnClickListener(this);

        note = (Note) getIntent().getSerializableExtra(INTENT_TASK);
//        if(note == null) {
//            toolbarTitle.setText(getString(R.string.add_task_title));
//            btnDelete.setImageResource(R.drawable.btn_done);
//            btnDelete.setTag(R.drawable.btn_done);
//            textTime.setText(AppUtils.getFormattedDateString(AppUtils.getCurrentDateTime()));
//
//        } else {
//            toolbarTitle.setText(getString(R.string.edit_task_title));
//            btnDelete.setImageResource(R.drawable.ic_delete);
//            btnDelete.setTag(R.drawable.ic_delete);
//            if(note.getTitle() != null && !note.getTitle().isEmpty()) {
//                editTitle.setText(note.getTitle());
//                editTitle.setSelection(editTitle.getText().length());
//            }
//            if(note.getDescription() != null && !note.getDescription().isEmpty()) {
//                editDesc.setText(note.getDescription());
//                editDesc.setSelection(editDesc.getText().length());
//            }
//            if(note.getCreatedDate() != null) {
//                Date.setText(note.getCreatedDate().toString());
//            }
//            if(note.getPassword() != null && !note.getPassword().isEmpty()) {
//                editPwd.setText(note.getPassword());
//                editPwd.setSelection(editPwd.getText().length());
//            }
//            checkBox.setChecked(note.isEncrypt());
//        }
//
        //AppUtils.openKeyboard(getApplicationContext());
    }

//    private void togglePwd() {
//        if(!pwdVisible) {
//            pwdVisible = Boolean.TRUE;
//            editPwd.setTransformationMethod(null);
//            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_pwd).mutate();
//            drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.line), PorterDuff.Mode.MULTIPLY));
//            editPwd.setCompoundDrawablesWithIntrinsicBounds(null,null, drawable, null);
//
//        } else {
//            pwdVisible = Boolean.FALSE;
//            editPwd.setTransformationMethod(new PasswordTransformationMethod());
//            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_pwd).mutate();
//            drawable.setColorFilter(new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY));
//            editPwd.setCompoundDrawablesWithIntrinsicBounds(null,null, drawable, null);
//        }
//        editPwd.setSelection(editPwd.length());
//    }


//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        if(b) {
//            editPwd.setVisibility(View.VISIBLE);
//            editPwd.setFocusable(true);
//        } else {
//            editPwd.setVisibility(View.INVISIBLE);
//        }
//    }

    private void showDatePicker(final Button button) {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog
        DatePickerDialog picker = new DatePickerDialog(AddNoteActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            date = DateFor.parse(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            Log.d("Nazar", date.toString());
                            DateFor = new SimpleDateFormat("dd MMMM");
                            stringDate = DateFor.format(date);
                            button.setText(stringDate);
                        }catch (ParseException e) {e.printStackTrace();}
                    }
                }, year, month, day);
        picker.show();
    }

    private void showTimePicker(final Button button) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(AddNoteActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                button.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.show();

    }

    @Override
    public void onClick(View view) {
        AppUtils.hideKeyboard(this);
        if(view == btnSave) {
            Intent intent = getIntent();
            if(note != null) {
                note.setTitle(editTitle.getText().toString());

                note.setCreatedDate(date);
                //note.setTime(editTitle2.getText().toString());
                //note.setDescription(editDesc.getText().toString());
                //note.setEncrypt(checkBox.isChecked());
                //note.setPassword(editPwd.getText().toString());
                intent.putExtra(INTENT_TASK, note);

            } else {
                intent.putExtra(INTENT_TITLE, editTitle.getText().toString());
                intent.putExtra(INTENT_DATE, date);
                //intent.putExtra(INTENT_TIME, editTitle2.getText().toString());
                //intent.putExtra(INTENT_DESC, editDesc.getText().toString());
                //intent.putExtra(INTENT_ENCRYPT, checkBox.isChecked());
                //intent.putExtra(INTENT_PWD, editPwd.getText().toString());
            }
            setResult(Activity.RESULT_OK, intent);
            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down);
        }
    }



}
