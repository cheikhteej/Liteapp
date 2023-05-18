package com.example.liteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.liteapp.DatabaseHelper;
import com.example.liteapp.R;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Créez une instance du DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Exemple d'insertion d'un article
        int articleId = 1;
        String articleTitle = "Mon titre";
        String articleContent = "Contenu de l'article";

        long rowId = databaseHelper.insertArticle(articleId, articleTitle, articleContent);

        if (rowId != -1) {
            Toast.makeText(this, "Article inséré avec succès", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erreur lors de l'insertion de l'article", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Fermez la base de données lorsque vous avez terminé
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}
