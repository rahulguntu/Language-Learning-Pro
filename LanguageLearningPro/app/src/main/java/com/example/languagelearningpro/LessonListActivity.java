package com.example.languagelearningpro;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LessonListActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public TextView titleListLessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        titleListLessons = findViewById(R.id.titleListLessons);

        Intent intent = getIntent();
        String selectedLanguage = "";
        String currEmail = "";
        String currUser = "";
        String cardType = "";

        if (intent != null){

            selectedLanguage = intent.getStringExtra("selectedLanguage");
            currEmail = intent.getStringExtra("currEmail");
            currUser = intent.getStringExtra("currUser");
            cardType = intent.getStringExtra("cardType");

        }

        titleListLessons.setText(selectedLanguage + " Lessons");

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);
        ImageButton logOutButton = findViewById(R.id.logOutBTN);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });
        String finalSelectedLanguage1 = selectedLanguage;
        String finalCardType = cardType;
        String finalCurrUser = currUser;
        String finalCurrEmail = currEmail;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LessonListActivity.this, LanguageSelectionActivity.class);
                intent.putExtra("selectedLanguage", finalSelectedLanguage1);
                intent.putExtra("currEmail", finalCurrEmail);
                intent.putExtra("currUser", finalCurrUser);
                intent.putExtra("cardType", finalCardType);

                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of Exercise objects
        List<LessonItem> lessonList = new ArrayList<>();
        lessonList.add(new LessonItem("1", "Lesson 1", "Past Simple Tense", "The past simple shows us that an action was in the past, not in the present. Regular past simple verbs have -ed at the end (e.g. called, played, arrived). Irregular verbs have a different form, usually with a different vowel sound. My parents called me yesterday.\n" +
                "I woke up early this morning.\n" +
                "Sam played basketball when he was at university."));
        lessonList.add(new LessonItem("2", "Lesson 2", "Past Continuous Tense", "When we use these two tenses together, it shows us that the past simple action happened in the middle of the past continuous action, while it was in progress. While I was studying, I suddenly felt sleepy. \n\nWe often use these tenses to show an action interrupting another action.\n\nI broke my leg when I was skiing.\n" +
                "As I was going to work, I saw an old friend.\n" +
                "We were watching television when the power went off."));
        lessonList.add(new LessonItem("3", "Lesson 3", "Countable Nouns", "For positive sentences we can use a/an for singular nouns or some for plurals.\n\nThere's a man at the door.\n" +
                "I have some friends in New York.\n\nFor negatives we can use a/an for singular nouns or any for plurals.\n\nI don't have a dog.\n" +
                "There aren't any seats."));
        lessonList.add(new LessonItem("4","Lesson 4", "Uncountable Nouns", "Here are some examples of uncountable nouns:\n\n1. Bread\n2.Rice \n3. Coffee \n4. Information \n5. Money \n6. Advice\n\nWe use some with uncountable nouns in positive sentences and any with negatives.\n\nThere's some milk in the fridge.\n" +
                "There isn't any coffee."));
        lessonList.add(new LessonItem("5", "Lesson 5", "Infinitive of Purpose", "Do you know how and when to use an infinitive to talk about purpose? When we want to answer the question why?, we can use an infinitive of purpose. Most of the time, we use the to-infinitive.\n\nWhy do you have the LearnEnglish Grammar app?\n" +
                "To improve my grammar.\n" +
                "\n" +
                "Why do we always eat at home?\n" +
                "We eat at home to save money.\n" +
                "\n" +
                "Why do you have a bicycle?\n" +
                "I use it to go to work.\n" +
                "\n" +
                "Why does she run every morning?\n" +
                "She runs to keep fit."));
        lessonList.add(new LessonItem("6", "Lesson 6", "Adjectives With One Syllable", "To make comparative forms with one-syllable adjectives, we usually add -er:\n\nold => older\n" +
                "clean => cleaner\n" +
                "slow => slower  \n\nIf an adjective ends in -e, we add -r:  \n\nsafe => safer\n" +
                "nice => nicer \n\nf an adjective ends in a vowel and a consonant, we usually double the consonant: \n\nbig => bigger\n" +
                "hot => hotter"));
        lessonList.add(new LessonItem("7", "Lesson 7", "Adjectives With Two or More Syllables", "If a two-syllable adjective ends in a consonant and -y, we change -y to -i and add -er:  \n\nnoisy => noisier\n" +
                "happy => happier\n" +
                "easy => easier \n\nWe use more to make comparative forms for most other two-syllable adjectives and for all adjectives with three or more syllables: \n\ncrowded => more crowded\n" +
                "stressful => more stressful\n" +
                "dangerous => more dangerous \n\nException: You can either add -er/-r or use more with some two-syllable adjectives, such as common, cruel, gentle, handsome, likely, narrow, pleasant, polite, simple and stupid. \n\nI think life in the countryside is simpler than in the city.\n" +
                "It's more simple to live in the city because everything you need is there."));
        lessonList.add(new LessonItem("8", "Lesson 8", "Irregular Adjectives", "The adjectives good, bad and far have irregular comparative forms: \n\ngood => better\n" +
                "bad => worse\n" +
                "far => further/farther \n\nWhen we want to say which person or thing we are comparing with, we can use than: \n\nTheir house is cleaner than ours.\n" +
                "Traffic is slower in the city than in the countryside.\n" +
                "After the race I was more tired than Anne."));
        lessonList.add(new LessonItem("9", "Lesson 9", "Past Ability","We usually use could or couldn't to talk about general abilities in the past. \n\nShe could paint before she started school.\n" +
                "I couldn't cook until I went to university.\n" +
                "When I lived next to the pool, I could go swimming every day. \n\nWhen we talk about achieving something on a specific occasion in the past, we use was/were able to (= had the ability to) and managed to (= succeeded in doing something difficult). \n\nThe burglar was able to get in through the bathroom window.\n" +
                "The burglar managed to get in through the bathroom window even though it was locked. \n\nCould is not usually correct when we're talking about ability at a specific moment in the past. \n\nWhen we talk about a specific occasion when someone didn't have the ability to do something, we can use wasn't/weren't able to, didn't manage to or couldn't. \n\nThe speaker wasn't able to attend the conference due to illness.\n" +
                "She couldn't watch the match because she was working.\n" +
                "They worked on it for months but they didn't manage to find a solution \n\nNote that wasn't/weren't able to is more formal than couldn't, while didn't manage to emphasises that the thing was difficult to do."));
        lessonList.add(new LessonItem("10", "Lesson 10", "Question Tags", "We can add question tags like isn't it?, can you? or didn't they? to a statement to make it into a question. Question tags are more common in speaking than writing.\n" +
                "\n" +
                "We often use question tags when we expect the listener to agree with our statement. In this case, when the statement is positive, we use a negative question tag.\n" +
                "\n" +
                "She's a doctor, isn't she?\n" +
                "Yesterday was so much fun, wasn't it?\n" +
                "\n" +
                "If the statement is negative, we use a positive question tag. \n" +
                "\n" +
                "He isn't here, is he?\n" +
                "The trains are never on time, are they?\n" +
                "Nobody has called for me, have they?\n" +
                "\n" +
                "If we are sure or almost sure that the listener will confirm that our statement is correct, we say the question tag with a falling intonation. If we are a bit less sure, we say the question tag with a rising intonation."));


// Initialize the adapter with the list of lessons
        LessonListAdapter adapter = new LessonListAdapter(lessonList);

// Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

// Set item click listeners to start individual exercises
        String finalSelectedLanguage = selectedLanguage;
        adapter.setOnItemClickListener(new LessonListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                LessonItem selectedLesson = lessonList.get(position);
                Intent intent = new Intent(LessonListActivity.this, CurrentLessonActivity.class);
                intent.putExtra("selectedLanguage", finalSelectedLanguage);
                intent.putExtra("lessonName", selectedLesson.getLessonName());
                intent.putExtra("lessonTitle", selectedLesson.getTitle());
                intent.putExtra("lessonDescription", selectedLesson.getDescription());
                intent.putExtra("currLesson", position);
                intent.putExtra("currEmail", finalCurrEmail);
                intent.putExtra("currUser", finalCurrUser);
                intent.putExtra("cardType", finalCardType);
                startActivity(intent);
            }
        });

    }
}
