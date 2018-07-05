package com.example.maximembabele.test_formatnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new NumberTextWatcher(editText));
    }

    class NumberTextWatcher implements TextWatcher {
        private boolean isDeleting;
        private DecimalFormat decimalFormat;
        private DecimalFormat noneDecimalFormat;
        private EditText editText;

        public NumberTextWatcher(EditText editText) {
            this.editText = editText;
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(22), new InputFilter() {
                @Override
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                    return new StringBuffer(dest).indexOf(".") > -1 && (source + "").equals(".") ? "" : null;
                }
            }});

            DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
            formatSymbols.setDecimalSeparator('.');
            formatSymbols.setGroupingSeparator(' ');

            decimalFormat = new DecimalFormat("#,###.##", formatSymbols);
            decimalFormat.setDecimalSeparatorAlwaysShown(true);
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);

            noneDecimalFormat = new DecimalFormat("#,###", formatSymbols);
            noneDecimalFormat.setRoundingMode(RoundingMode.FLOOR);
        }

        String beforeText;
        int pCursor;

        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            isDeleting = after == 0;
            if (!isDeleting && s.length() >= 4 && (start - 1 >= 0 && s.charAt(start - 1) == '.' && start + 1 < s.length()
                    || start - 2 >= 0 && s.charAt(start - 2) == '.') && start < s.length())
                beforeText = s.toString();
            else beforeText = null;
            pCursor = editText.getSelectionStart();
        }

        @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        boolean isFraction(Editable s) {
            return s.toString().contains(String.valueOf(decimalFormat.getDecimalFormatSymbols().getDecimalSeparator()));
        }

        @Override public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s.toString())) {
                if (isDeleting && s.toString().equals("R ")) {
                    s.replace(0, s.length(), "");
                } else {
                    boolean leftShiftCursor = s.toString().contains(" .");
                    String value = s.toString().replace(" ", "").replace("R", "");
                    int cursor = editText.length() - editText.getSelectionStart();
                    int lBefore = editText.length();
                    try {
                        double d = Double.parseDouble(value);
                        Log.d("x-l", "double " + d);
                        value = isFraction(s) ? decimalFormat.format(d) : noneDecimalFormat.format(d);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (beforeText != null) value = beforeText;
                    if (!value.isEmpty()) value = "R " + value;
                    if (!TextUtils.equals(s, value)) {
                        s.replace(0, s.length(), value);
                        int lAfter = editText.length();
                        int diff = (lAfter - lBefore);
                            Log.d("x-l", "z " + (diff));
                        if (leftShiftCursor) pCursor--;
                        if (diff < -1 && pCursor - 1 > -1) {
                            editText.setSelection(pCursor);
                        } else if (editText.length() - cursor >= 0) {
                            editText.setSelection(editText.length() - cursor);
                        }
                    }
                }
            }
        }
    }
}