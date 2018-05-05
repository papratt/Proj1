package com.example.paige.proj1.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void Convert(View view) {

        EditText from = findViewById(R.id.from);

        RadioGroup fromGroup = findViewById(R.id.fromGroup);
        RadioGroup toGroup = findViewById(R.id.toGroup);

        fromGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText from = findViewById(R.id.from);
                EditText to = findViewById(R.id.to);
                Double toInput = Double.parseDouble(to.getText().toString());
                RadioGroup toGroup = findViewById(R.id.toGroup);
                if (checkedId == R.id.fromUSD) {
                    if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
                        from.setText(toInput.toString());
                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
                        toInput *= 9832.82;
                        from.setText(toInput.toString());
                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
                        toInput *= 1 / 189.19;
                        from.setText(toInput.toString());
                    }
                } else if (checkedId == R.id.fromBTC) {
                    if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
                        toInput *= 0.00010;
                        from.setText(toInput.toString());
                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
                        from.setText(toInput.toString());
                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
                        toInput *= 1 / 1860237.00;
                        from.setText(toInput.toString());
                    }
                } else if (checkedId == R.id.fromDOGE) {
                    if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
                        toInput *= 188.964475;
                        from.setText(toInput.toString());
                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
                        toInput *= 1860237.00;
                        from.setText(toInput.toString());
                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
                        from.setText(toInput.toString());
                    }
                }
            }
        });

        toGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText from = findViewById(R.id.from);
                EditText to = findViewById(R.id.to);
                Double fromInput = Double.parseDouble(from.getText().toString());
                RadioGroup fromGroup = findViewById(R.id.fromGroup);
                if (checkedId == R.id.toUSD) {
                    if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
                        to.setText(fromInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
                        fromInput *= 9832.82;
                        to.setText(fromInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
                        fromInput *= 1 / 189.19;
                        to.setText(fromInput.toString());
                    }
                } else if (checkedId == R.id.toBTC) {
                    if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
                        fromInput *= 0.00010;
                        to.setText(fromInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
                        to.setText(fromInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
                        fromInput *= 1 / 1860237.00;
                        to.setText(fromInput.toString());
                    }
                } else if (checkedId == R.id.toDOGE) {
                    if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
                        fromInput *= 188.964475;
                        to.setText(fromInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
                        fromInput *= 1860237.00;
                        to.setText(fromInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
                        to.setText(fromInput.toString());
                    }
                }
            }
        });
        from.addTextChangedListener(new TextWatcher() {
            boolean userChange;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userChange = Math.abs(count - before) == 1;

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    return;
                }
                if (!userChange) {
                    return;
                }
                EditText to = findViewById(R.id.to);
                RadioGroup fromGroup = findViewById(R.id.fromGroup);
                RadioGroup toGroup = findViewById(R.id.toGroup);
                Double sInput = Double.parseDouble(s.toString());
                if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
                    if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
                        to.setText(sInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
                        sInput *= 9832.82;
                        to.setText(sInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
                        sInput *= 1 / 189.19;
                        to.setText(sInput.toString());
                    }
                } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
                    if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
                        sInput *= 0.00010;
                        to.setText(sInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
                        to.setText(sInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
                        sInput *= 1 / 1860237.00;
                        to.setText(sInput.toString());
                    }
                } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
                    if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
                        sInput *= 188.964475;
                        to.setText(sInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
                        sInput *= 1860237.00;
                        to.setText(sInput.toString());
                    } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
                        to.setText(sInput.toString());
                    }
                }
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Crypto Converter");
    }

}








//        to.addTextChangedListener(new TextWatcher() {
//            boolean uChange;
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                uChange = Math.abs(count - before) == 1;
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.toString().isEmpty()) {
//                    return;
//                }
//                if (!uChange) {
//                    return;
//                }
//                EditText from = findViewById(R.id.from);
//                RadioGroup fromGroup = findViewById(R.id.fromGroup);
//                RadioGroup toGroup = findViewById(R.id.toGroup);
//                Double sInput = Double.parseDouble(s.toString());
//                if (fromGroup.getCheckedRadioButtonId() == R.id.fromUSD) {
//                    if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
//                        from.setText(sInput.toString());
//                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
//                        sInput *= 9832.82;
//                        from.setText(sInput.toString());
//                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
//                        sInput *= 1 / 189.19;
//                        from.setText(sInput.toString());
//                    }
//                } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromBTC) {
//                    if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
//                        sInput *= 0.00010;
//                        from.setText(sInput.toString());
//                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
//                        from.setText(sInput.toString());
//                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
//                        sInput *= 1 / 1860237.00;
//                        from.setText(sInput.toString());
//                    }
//                } else if (fromGroup.getCheckedRadioButtonId() == R.id.fromDOGE) {
//                    if (toGroup.getCheckedRadioButtonId() == R.id.toUSD) {
//                        sInput *= 188.964475;
//                        from.setText(sInput.toString());
//                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toBTC) {
//                        sInput *= 1860237.00;
//                        from.setText(sInput.toString());
//                    } else if (toGroup.getCheckedRadioButtonId() == R.id.toDOGE) {
//                        from.setText(sInput.toString());
//                    }
//                }
//            }
//
//        });


