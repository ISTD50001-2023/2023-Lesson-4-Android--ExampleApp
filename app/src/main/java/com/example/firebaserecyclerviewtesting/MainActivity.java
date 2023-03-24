package com.example.firebaserecyclerviewtesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextEnterWord;
    Button buttonAddWord;
    TextView textViewNumber;

    RecyclerView recyclerView;
    final String TAG = "TestingApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEnterWord = findViewById(R.id.editTextEnterWord);
        buttonAddWord = findViewById(R.id.buttonAddWord);

        recyclerView = findViewById(R.id.recyclerView);
        textViewNumber = findViewById(R.id.textViewNumber);
        
        /* WordsDataSource wordsDataSource = new LocalWordsData(textViewNumber); */
        WordsDataSource wordsDataSource = new FirebaseWordsData(textViewNumber);

        RecyclerView.Adapter<WordsAdapter.WordsHolder> adapter
                = new WordsAdapter(this, wordsDataSource);
        recyclerView.setAdapter( adapter );
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        buttonAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String word = editTextEnterWord.getText().toString();
                if( !word.isEmpty() ){
                    wordsDataSource.addWord( editTextEnterWord.getText().toString());
                }
            }
        });

    }
}