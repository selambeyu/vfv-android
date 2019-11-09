package com.example.vfv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.vfv1.ui.Articles.ArticlesActivity;
import com.example.vfv1.ui.Ask_Questions.AskQuestionActivity;
import com.example.vfv1.ui.Education.EducationActivity;
import com.example.vfv1.ui.Professionals.CareerPaths;
import com.example.vfv1.ui.Professionals.ProfessionalsActivity;
import com.example.vfv1.ui.Vision.VisionActivity;
import com.example.vfv1.ui.training.TrainingActivity;

public class Students extends AppCompatActivity {

    LinearLayout btnTrainingCenter;
    LinearLayout btnVision;
    LinearLayout btnprofessionals, articles, professionals, education, career;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        btnTrainingCenter = findViewById(R.id.traningcenter);
        btnVision = findViewById(R.id.vision);
        btnprofessionals = findViewById(R.id.professionals);
        articles = findViewById(R.id.articles);
        professionals = findViewById(R.id.professionals);
        education = findViewById(R.id.education);
        career = findViewById(R.id.career);


        btnTrainingCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, TrainingActivity.class);
                startActivity(intent);
            }
        });
        btnVision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, VisionActivity.class);
                startActivity(intent);
            }
        });
        btnprofessionals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, ProfessionalsActivity.class);
                startActivity(intent);
            }
        });

        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, ArticlesActivity.class);
                startActivity(intent);
            }
        });

        professionals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, ProfessionalsActivity.class);
                startActivity(intent);
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, AskQuestionActivity.class);
                startActivity(intent);
            }
        });

        career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Students.this, CareerPaths.class);
                startActivity(intent);
            }
        });


    }
}
