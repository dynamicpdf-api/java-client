package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Outline {

    private Color color;
    private String colorName;
    private String text;
    private OutlineStyle style;
    private boolean expanded;
    private List<Outline> children = new ArrayList<Outline>();
    private Action action;
    private String fromInputID;

    public Outline(PdfInput input) {
        fromInputID = input.getId();
    }

    public Outline(String text, Action action) {
        this.text = text;
        this.action = action;
    }

    public Outline(String text) {
        this(text, null);
    }

    @JsonProperty("color")
    String getColorName() {
        return colorName;
    }

    void setColorName(String value) {
        colorName = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        text = value;
    }

    public OutlineStyle getStyle() {
        return style;
    }

    public void setStyle(OutlineStyle value) {
        style = value;
    }

    public boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(boolean value) {
        expanded = value;
    }

    public List<Outline> getChildren() {
        return children;
    }

    public void setChildren(List<Outline> value) {
        children = value;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        action = value;
    }

    String getFromInputID() {
        return fromInputID;
    }

    void setFromInputID(String value) {
        fromInputID = value;
    }

    @JsonIgnore
    public Color getColor() {
        return color;
    }

    public void setColor(Color value) {
        color = value;
        colorName = color.getColorString();
    }

}
