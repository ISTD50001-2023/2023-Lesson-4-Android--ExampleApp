package com.example.firebaserecyclerviewtesting;

import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirebaseWordsData implements WordsDataSource {

    public static final String FIREBASE_TESTING = "FirebaseTesting";
    DatabaseReference databaseReference;
    DatabaseReference wordsDatabaseReference;
    int size;

    List<String> stringList;
    TextView t;

    FirebaseWordsData(TextView t){

        databaseReference = FirebaseDatabase.getInstance().getReference();
        wordsDatabaseReference = databaseReference.child("words");

        this.t = t;
        wordsDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                countListItems(snapshot);
                repopulateList(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void countListItems(DataSnapshot snapshot){
        size = (int) snapshot.getChildrenCount();
        t.setText( String.valueOf(size));
        Log.d(FIREBASE_TESTING, "constructor size " + size);
    }

    private void repopulateList(DataSnapshot snapshot){
        stringList = new ArrayList<>();
        for(DataSnapshot dataSnapshot: snapshot.getChildren()){
            String s = dataSnapshot.getValue(String.class);
            stringList.add(s);
            Log.d(FIREBASE_TESTING, dataSnapshot.getValue(String.class));
        }
    }


    public void addWord(String s){
        wordsDatabaseReference.push().setValue(s);
        Log.d(FIREBASE_TESTING, "add word size " + size);
    }

    public String getWord(int i){
        return stringList.get(i);
    }

    public void removeWord(int i){

        String word = stringList.get(i);

        wordsDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    if( dataSnapshot.getValue().toString().equals(word) ){
                        Log.d(FIREBASE_TESTING, "word:" + word + dataSnapshot.getValue().toString());
                        wordsDatabaseReference.child(dataSnapshot.getKey()).removeValue();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public int getSize(){
        return size;
    }

}
