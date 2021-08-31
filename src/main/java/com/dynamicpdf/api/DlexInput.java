package com.dynamicpdf.api;

/**
 * Represents a Dlex input.
 */

public class DlexInput extends Input {

	private String layoutDataResourceName;

	/**
	 * Initializes a new instance of the <code>DlexInput</code> class by posting the 
	 * DLEX file and the JSON data file from the client to the API to create the PDF report.
	 * @param dlexResource The <code>DlexResource</code>, dlex file created as per the desired PDF report layout design.
	 * @param layoutData The <code>LayoutDataResource</code>, json data file used to create the PDF report.
	 */

	public DlexInput(DlexResource dlexResource, LayoutDataResource layoutData) {
		super();
		setResourceName(dlexResource.getResourceName());
		layoutDataResourceName = layoutData.getLayoutDataResourceName();
		getResources().add(dlexResource);
		getResources().add(layoutData);

	}

	/**
	 * Initializes a new instance of the <code>DlexInput</code> class by taking the 
	 * DLEX file path that is present in the cloud environment and the JSON data file from the client.
	 * @param cloudResourcePath The DLEX file path present in the resource manager.
	 * @param layoutData The <code>LayoutDataResource</code>, json data file used to create the PDF report.
	 */

	public DlexInput(String cloudResourcePath, LayoutDataResource layoutData) {
		super();
		setResourceName(cloudResourcePath);
		layoutDataResourceName = layoutData.getLayoutDataResourceName();
		getResources().add(layoutData);
	}

	/**
	 * Initializes a new instance of the <code>DlexInput</code> class.
	 * @param cloudResourcePath The DLEX file path present in the resource manager.
	 * @param cloudLayoutDataPath The JSON data file path present in the resource manager used to create the PDF report.
	 */

	public DlexInput(String cloudResourcePath, String cloudLayoutDataPath) {
		super();
		setResourceName(cloudResourcePath);
		layoutDataResourceName = cloudLayoutDataPath;
	}

	InputType getType() {
		return InputType.DLEX;
	}

	/**
	 * Gets the name for layout data resource.
	 * @return The Name of Layout Data Resource 
	 */
	public String getLayoutDataResourceName() {
		return layoutDataResourceName;
	}

	/**
	 * sets the name for layout data resource.
	 * @param value The name for layout data resource.
	 */
	public void setLayoutDataResourceName(String value) {
		layoutDataResourceName = value;
	}
}
