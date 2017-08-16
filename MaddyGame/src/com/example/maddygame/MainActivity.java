package com.example.maddygame;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button stone,paper,scissor;
	ImageView cpu,me;
	String mychoice,cpuchoice,result;
	Random r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stone=(Button)findViewById(R.id.stone);
		paper=(Button)findViewById(R.id.paper);
		scissor=(Button)findViewById(R.id.scissor);
		cpu=(ImageView)findViewById(R.id.cpu);
		me=(ImageView)findViewById(R.id.me);
		r= new Random();
		stone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mychoice="rock";
				me.setImageResource(R.drawable.stone);
				calculate();
			}
		});
		
	paper.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mychoice="paper";
				me.setImageResource(R.drawable.paper);
				calculate();
			}
		});
	
	scissor.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			mychoice="scissor";
			me.setImageResource(R.drawable.scissor);
			calculate();
		}
	});
	}
	protected void calculate() {
		int cp=r.nextInt(3);
		if(cp==0)
		{
			cpuchoice="rock";
			cpu.setImageResource(R.drawable.stone);
		}
		else if(cp==1)
		{
			cpuchoice="paper";
			cpu.setImageResource(R.drawable.paper);
		}
		else if(cp==2)
		{
			cpuchoice="scissor";
			cpu.setImageResource(R.drawable.scissor);
		}
		
		if(mychoice.equals("rock") && cpuchoice.equals("paper"))
			result="you lose";
		
		if(mychoice.equals("rock") && cpuchoice.equals("scissor"))
			result="you win";
		
		if(mychoice.equals("paper") && cpuchoice.equals("rock"))
			result="you win";
		
		if(mychoice.equals("paper") && cpuchoice.equals("scissor"))
			result="you lose";
		
		if(mychoice.equals("scissor") && cpuchoice.equals("paper"))
			result="you win";
		
		if(mychoice.equals("scissor") && cpuchoice.equals("rock"))
			result="you lose";
		
		if(mychoice.equals("scissor") && cpuchoice.equals("scissor"))
			result="math draw";
		
		if(mychoice.equals("rock") && cpuchoice.equals("rock"))
			result="math draw";
		
		if(mychoice.equals("paper") && cpuchoice.equals("paper"))
			result="math draw";
		
		Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
		
	}



}
