package com.example.maximembabele.test_spannable;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.UnderlineSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            String original;

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                original = textView.getText().toString();
            }

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override public void afterTextChanged(Editable s) {
                String text = textView.getText().toString().toLowerCase();
                String searchText = editText.getText().toString().toLowerCase();
                int start = text.toLowerCase().indexOf(searchText);
                int end = start + searchText.length();

                if (start >= 0) {
                    Spannable spannable = new SpannableString(textView.getText().toString());
                    ColorStateList red = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.RED});
                    TextAppearanceSpan highlightSpan = new TextAppearanceSpan(null, Typeface.BOLD_ITALIC, 18, red, null);
                    spannable.setSpan(highlightSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    textView.setText(spannable);
                } else {
                    textView.setText(original);
                }
            }
        });
    }
}