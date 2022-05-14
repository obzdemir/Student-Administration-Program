package com.company.GUI;

import javax.swing.*;

public class JReferencingButton<T> extends JButton {
    private T value;

    public JReferencingButton(String text, T value) {
        super(text);
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }
}