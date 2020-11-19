package com.example.android.practice;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadRawTextFile {

    private InputStream inputStream;
    private BufferedReader bufferedReader = null;
    private StringBuilder text = new StringBuilder();

    public String readRawTextFile(Context context, int resourceId) {

        try {
            inputStream = context.getResources().openRawResource(resourceId);

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while (( line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }

        } catch (Exception e) {
            Toast.makeText(context.getApplicationContext(),"Error reading file!", Toast.LENGTH_LONG).show();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return text.toString();
    }
}
