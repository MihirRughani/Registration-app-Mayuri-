package com.example.sqlite;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;


public class Course_selection extends Activity implements OnClickListener
{
	CheckBox boxphp, boxandroid, boxhtml, boxauto, boxliveproject, boxother;
	Button submitbtn;
	ImageView calimage;
	TextView datetextview;
	int checked=0;
	private int mYear, mMonth, mDay;
	
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_selection);
 
		
		calimage=(ImageView)findViewById(R.id.calimageView);
		datetextview=(TextView)findViewById(R.id.datetextview);
		
		
		calimage.setOnClickListener(this);
		 

		boxphp=(CheckBox)findViewById(R.id.checkPHP);
		boxandroid=(CheckBox)findViewById(R.id.checkANDROID);
		boxhtml=(CheckBox)findViewById(R.id.checkCSS);
		boxauto=(CheckBox)findViewById(R.id.checkAUTOCAD);
		boxliveproject=(CheckBox)findViewById(R.id.checkLIVE);
		
		/*boxphp.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
			{
				if(isChecked)
				{
					checked=1;
				}else
				{
					checked=0;
				}
				
			}
		});
		*/
		
	}
	


	@Override
	public void onClick(View v)
	{
		if(v == calimage)
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
                        	datetextview.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              
                        }
                    }, mYear, mMonth, mDay);
            
            dpd.show();
		}
	}
	
	
	

}
