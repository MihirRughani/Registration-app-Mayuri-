package com.example.sqlite;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Schedule_timing extends Activity implements OnItemSelectedListener 
{

	
	Spinner spinnerdate, spinnername;
	TextView starttext, stoptext;
	Button startbtn, stopbtn;
	ImageView startImage, stopImage;
	private String[] date_info = {"Monday to Saturday", "Mon-Wed-Fri", "Tue-Thu-Sat", "Mon-Tue-Wed", "Thu-Fri-Sat"};
	private String[] trainer_name={"Nayan Sir"};
	private int mYear, mMonth, mDay;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.schedule_timing);
		 
		 spinnerdate=(Spinner)findViewById(R.id.spinnerdate);
		 spinnername=(Spinner)findViewById(R.id.spinnertrainer);
		 
		 startImage=(ImageView)findViewById(R.id.imageStartdate);
		 stopImage=(ImageView)findViewById(R.id.imageStopdate);
		 
		 startbtn=(Button)findViewById(R.id.buttonStart);
		 stopbtn=(Button)findViewById(R.id.buttonStop);
		 
		 ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date_info);
		 adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 spinnerdate.setAdapter(adapter1);
		 spinnerdate.setOnItemSelectedListener(this);
		 
		 
		 ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, trainer_name);
		 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 spinnername.setAdapter(adapter2);
		 spinnername.setOnItemSelectedListener(this);
		 
		 
	
	}
	

	
	public void onClick(View v)
	{
		if(v == startImage)
		{
			final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
 
            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() 
            {
 
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                        {
                            // Display Selected date in textbox
                        	startbtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              
                        }
                    }, mYear, mMonth, mDay);
            
            dpd.show();
		}
	}





	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	



	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
