package com.dynamicpdf.api;

public class DlexInput extends Input {

    private String layoutDataResourceName;

    public DlexInput(DlexResource dlexResource, LayoutDataResource layoutData) {
        super();
        setResourceName(dlexResource.getResourceName());
        layoutDataResourceName = layoutData.getLayoutDataResourceName();
        getResources().add(dlexResource);
        getResources().add(layoutData);

    }

    public DlexInput(String cloudResourcePath, LayoutDataResource layoutData) {
        super();
        setResourceName(cloudResourcePath);
        layoutDataResourceName = layoutData.getLayoutDataResourceName();
        getResources().add(layoutData);
    }

    public DlexInput(String cloudResourcePath, String cloudLayoutDataPath) {
        super();
        setResourceName(cloudResourcePath);
        layoutDataResourceName = cloudLayoutDataPath;
    }

    InputType getType() {
        return InputType.DLEX;
    }

    public String getLayoutDataResourceName() {
        return layoutDataResourceName;
    }

    public void setLayoutDataResourceName(String value) {
        layoutDataResourceName = value;
    }
}
